package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.model.FacultyDTO;
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

    public FacultyDTO save(FacultyDTO house) {
        return FacultyDTO.fromFaculty(facultyRepository.save(house.toFaculty()));
    }

    public FacultyDTO findHouseById(Long id) {
        return FacultyDTO.fromFaculty(facultyRepository.findById(id).get());
    }

    public FacultyDTO updateHouse(FacultyDTO house) {
        return FacultyDTO.fromFaculty(facultyRepository.save(house.toFaculty()));
    }

    public void deleteHouseById(Long id) {
        facultyRepository.deleteById(id);
    }

    //get List of houses by color
    public List<FacultyDTO> findHouseByColor(String color) {
        return facultyRepository.findAll().stream()
                .filter(house -> house.getColor().equals(color))
                .map(FacultyDTO::fromFaculty)
                .collect(Collectors.toList());
    }

    public Faculty findHouseByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }

}
