package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.model.FacultyDTO;
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
    public ResponseEntity<FacultyDTO> findHouseById(@PathVariable Long id) {
        FacultyDTO facultyDTO = houseService.findHouseById(id);
        if (facultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTO);
    }

    //create house
    @GetMapping("/createHouse")
    public ResponseEntity<FacultyDTO> createHouse(@RequestBody FacultyDTO house) {
        return ResponseEntity.ok(houseService.save(house));
    }

    //edit house
    @GetMapping("/editHouse")
    public ResponseEntity<FacultyDTO> editHouse(@RequestBody FacultyDTO house) {
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
    public ResponseEntity<List<FacultyDTO>> findHouseByColor(@PathVariable String color) {
        return ResponseEntity.ok(houseService.findHousesByColor(color));
    }

    //find house by name
    @GetMapping("/findHouseByName/{name}")
    public ResponseEntity<Faculty> findHouseByName(@PathVariable String name) {
        return ResponseEntity.ok(houseService.findHouseByName(name));
    }
}
