package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findStudentByAge/{age}")
    public ResponseEntity<List<Student>> findStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.findStudentByAge(age));
    }


}
