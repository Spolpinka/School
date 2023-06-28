package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.service.HouseService;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    //find house by id
    @GetMapping("/findHouseById/{id}")
    public ResponseEntity<Faculty> findHouseById(@PathVariable Long id) {
        Faculty faculty = houseService.findHouseById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    //create house
    @GetMapping("/createHouse")
    public ResponseEntity<Faculty> createHouse(@RequestBody Faculty house) {
        return ResponseEntity.ok(houseService.save(house));
    }

    //edit house
    @GetMapping("/editHouse")
    public ResponseEntity<Faculty> editHouse(@RequestBody Faculty house) {
        return ResponseEntity.ok(houseService.updateHouse(house));
    }

    //delete house
    @GetMapping("/deleteHouse/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.ok().build();
    }



    //find house by color
    @GetMapping("/findHouseByColor/{color}")
    public ResponseEntity<List<Faculty>> findHouseByColor(@PathVariable String color) {
        return ResponseEntity.ok(houseService.findHouseByColor(color));
    }

    //find house by name
    @GetMapping("/findHouseByName/{name}")
    public ResponseEntity<Faculty> findHouseByName(@PathVariable String name) {
        return ResponseEntity.ok(houseService.findHouseByName(name));
    }
}
