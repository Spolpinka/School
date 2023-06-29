package pro.sky.hogwards.school.service;

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

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO save(StudentDTO student) {
        return StudentDTO.fromStudent(studentRepository.save(student.toStudent()));
    }

    public StudentDTO getStudentById(Long id) {
        return StudentDTO.fromStudent(studentRepository.findById(id).get());
    }

    public StudentDTO updateStudent(StudentDTO student) {
        return StudentDTO.fromStudent(studentRepository.save(student.toStudent()));
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> findStudentByAge(int age) {
        return studentRepository.findAllByAge(age).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find all students
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> findAllStudents(int page, int size) {
        if (size < 0 || size > 50) {
            System.out.println("Size must be between 0 and 50");
            size = 50;
        }
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return studentRepository.findAll(pageRequest).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find student by id between min and max
    public Collection<StudentDTO> findStudentByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    public int getCountOfStudents() {
        return studentRepository.getCountOfStudents();
    }

    public double getAverageAgeOfStudents() {
        return studentRepository.getAverageAgeOfStudents();
    }

    public Collection<StudentDTO> getFiveYoungestStudents() {
        return studentRepository.getFiveYoungestStudents().stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }
}
