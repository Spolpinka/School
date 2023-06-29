package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.repository.FacultyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HouseService {
    private final FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty save(Faculty house) {
        return facultyRepository.save(house);
    }

    public Faculty findHouseById(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty updateHouse(Faculty house) {
        return facultyRepository.save(house);
    }

    public void deleteHouseById(Long id) {
        facultyRepository.deleteById(id);
    }

    //get List of houses by color
    public List<Faculty> findHouseByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

}
