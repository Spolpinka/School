package pro.sky.hogwards.school.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentByAge(int age) {
        return studentRepository.findAllByAge(age);
    }

    //find all students
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudents(int page, int size) {
        if (size < 0 || size > 50) {
            System.out.println("Size must be between 0 and 50");
            size = 50;
        }
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return studentRepository.findAll(pageRequest).toList();
    }

    //find student by id between min and max
    public Collection<Student> findStudentByAgeBetween(int min, int max) {
        return studentRepository.findAllByAgeBetween(min, max);
    }


}
