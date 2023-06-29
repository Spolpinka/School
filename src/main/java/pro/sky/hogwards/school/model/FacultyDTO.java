package pro.sky.hogwards.school.model;

import lombok.Data;

@Data
public class FacultyDTO {
    private Long id;
    private String name;
    private String color;

    public static FacultyDTO fromFaculty(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setId(faculty.getId());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setColor(faculty.getColor());
        return facultyDTO;
    }

    public Faculty toFaculty() {
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);
        return faculty;
    }
}
