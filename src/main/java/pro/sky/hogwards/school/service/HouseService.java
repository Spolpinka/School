package pro.sky.hogwards.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Faculty;
import pro.sky.hogwards.school.model.FacultyDTO;
import pro.sky.hogwards.school.repository.FacultyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {
    Logger logger = LoggerFactory.getLogger(HouseService.class);
    private final FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public FacultyDTO save(FacultyDTO house) {
        logger.info("Saving house: {}", house.getName());
        return FacultyDTO.fromFaculty(facultyRepository.save(house.toFaculty()));
    }

    public FacultyDTO findHouseById(Long id) {
        logger.info("Getting house by id: {}", id);
        return FacultyDTO.fromFaculty(facultyRepository.findById(id).get());
    }

    public FacultyDTO updateHouse(FacultyDTO house) {
        logger.info("Updating house: {}", house.getName());
        return FacultyDTO.fromFaculty(facultyRepository.save(house.toFaculty()));
    }

    public void deleteHouseById(Long id) {
        logger.info("Deleting house by id: {}", id);
        facultyRepository.deleteById(id);
    }

    //get List of houses by color
    public List<FacultyDTO> findHousesByColor(String color) {
        logger.info("Getting houses by color: {}", color);
        return facultyRepository.findAllByColorIgnoreCase(color).stream()
                .map(FacultyDTO::fromFaculty)
                .collect(Collectors.toList());
    }

    public Faculty findHouseByName(String name) {
        logger.info("Getting house by name: {}", name);
        return facultyRepository.findByNameIgnoreCase(name);
    }

}
