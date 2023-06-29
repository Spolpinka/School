package pro.sky.hogwards.school.model;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private int age;
    private Faculty faculty;


    public static StudentDTO fromStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setAge(student.getAge());
        studentDTO.setFaculty(student.getFaculty());
        return studentDTO;
    }

    public Student toStudent() {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setFaculty(getFaculty());
        return student;
    }
}
