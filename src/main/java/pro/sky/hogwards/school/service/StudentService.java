package pro.sky.hogwards.school.service;

import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    Map<Long, Student> students = new HashMap<>();
    static long id = 0;

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
        students.put(id, student);
        return student;
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
