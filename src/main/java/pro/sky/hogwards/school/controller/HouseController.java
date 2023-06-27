package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    //find house by color
    @GetMapping("/findHouseByColor/{color}")
    public ResponseEntity<List<Faculty>> findHouseByColor(@PathVariable String color) {
        return ResponseEntity.ok(houseService.findHouseByColor(color));
    }
}
