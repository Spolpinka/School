package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    static long id = 0;

    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setId(++id);
        students.put(id, student);
        return student;
    }

    public Student getStudentById(Long id) {
        return students.get(id);
    }

    public Student updateStudentById(Long id, Student student) {
        student.setId(id);
        if (students.values().contains(student)) {
            students.put(id, student);
            return student;
        }
        return null;
    }

    public void deleteStudentById(Long id) {
        students.remove(id);
    }

    public List<Student> findStudentByAge(int age) {

        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
