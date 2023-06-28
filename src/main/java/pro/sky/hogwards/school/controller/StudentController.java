package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //find student by id
    @GetMapping("/findStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    //create student
    @GetMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    //edit student
    @GetMapping("/editStudent")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    //find all students
    @GetMapping("/findAllStudents")
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @GetMapping("/findStudentByAge/{age}")
    public ResponseEntity<List<Student>> findStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.findStudentByAge(age));
    }

    //find student by age between min and max
    @GetMapping("/findStudentByAgeBetween/{min}/{max}")
    public ResponseEntity<Collection<Student>> findStudentByAgeBetween(@PathVariable int min, @PathVariable int max) {
        return ResponseEntity.ok(studentService.findStudentByAgeBetween(min, max));
    }

}
