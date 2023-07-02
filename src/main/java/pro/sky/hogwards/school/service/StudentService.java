package pro.sky.hogwards.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.StudentDTO;
import pro.sky.hogwards.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    final private StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO save(StudentDTO student) {
        logger.info("Saving student: {}", student.getName());
        return StudentDTO.fromStudent(studentRepository.save(student.toStudent()));
    }

    public StudentDTO getStudentById(Long id) {
        logger.info("Getting student by id: {}", id);
        return StudentDTO.fromStudent(studentRepository.findById(id).get());
    }

    public StudentDTO updateStudent(StudentDTO student) {
        logger.info("Updating student: {}", student.getName());
        return StudentDTO.fromStudent(studentRepository.save(student.toStudent()));
    }

    public void deleteStudentById(Long id) {
        logger.info("Deleting student by id: {}", id);
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> findStudentByAge(int age) {
        logger.info("Getting student by age: {}", age);
        return studentRepository.findAllByAge(age).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find all students
    public List<StudentDTO> findAllStudents() {
        logger.info("Getting all students");
        return studentRepository.findAll().stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> findAllStudents(int page, int size) {
        logger.info("Getting all students with pagination: page {}, size {}", page, size);
        if (size < 0 || size > 50) {
            logger.info("Size must be between 0 and 50");
            size = 50;
        }
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return studentRepository.findAll(pageRequest).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find student by id between min and max
    public Collection<StudentDTO> findStudentByAgeBetween(int min, int max) {
        logger.info("Getting student by age between: {} and {}", min, max);
        return studentRepository.findByAgeBetween(min, max).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    public int getCountOfStudents() {
        logger.info("Getting count of students");
        return studentRepository.getCountOfStudents();
    }

    public double getAverageAgeOfStudents() {
        logger.info("Getting average age of all students");
        return studentRepository.getAverageAgeOfStudents();
    }

    public Collection<StudentDTO> getFiveYoungestStudents() {
        logger.info("Getting five youngest students");
        return studentRepository.getFiveYoungestStudents().stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }
}
