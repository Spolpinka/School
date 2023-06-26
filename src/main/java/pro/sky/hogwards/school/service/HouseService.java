package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.repository.FacultyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HouseService {
    private Map<Long, Faculty> houses = new HashMap<>();
    private static long id = 0;

    private final FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createHouse(Faculty house) {
        house.setId(++id);
        houses.put(id, house);
        return house;
    }

    public Faculty getHouseById(Long id) {
        return houses.get(id);
    }

    public Faculty updateHouseById(Long id, Faculty house) {
        house.setId(id);
        if (houses.values().contains(house)) {
            houses.put(id, house);
            return house;
        }
        return null;
    }

    public void deleteHouseById(Long id) {
        houses.remove(id);
    }

    //get List of houses by color
    public List<Faculty> findHouseByColor(String color) {
        return houses.values().stream()
                .filter(house -> house.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
