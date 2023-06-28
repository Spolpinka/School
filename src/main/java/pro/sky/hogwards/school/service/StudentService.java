package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.model.StudentDTO;
import pro.sky.hogwards.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age)
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find all students
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    //find student by id between min and max
    public Collection<StudentDTO> findStudentByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max).stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }
}
