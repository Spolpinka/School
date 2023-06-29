package pro.sky.hogwards.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwards.school.model.Student;
import pro.sky.hogwards.school.model.StudentDTO;
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
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        if (studentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDTO);
    }

    //create student
    @PostMapping()
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    //edit student
    @PutMapping()
    public ResponseEntity<StudentDTO> editStudent(@RequestBody StudentDTO student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    //find all students
    @GetMapping("/findAllStudents")
    public ResponseEntity<List<StudentDTO>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @GetMapping("/findStudentByAge/{age}")
    public ResponseEntity<List<StudentDTO>> findStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.findStudentByAge(age));
    }

    //find student by age between min and max
    @GetMapping("/findStudentByAgeBetween/{min}/{max}")
    public ResponseEntity<Collection<StudentDTO>> findStudentByAgeBetween(@PathVariable int min, @PathVariable int max) {
        return ResponseEntity.ok(studentService.findStudentByAgeBetween(min, max));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}
