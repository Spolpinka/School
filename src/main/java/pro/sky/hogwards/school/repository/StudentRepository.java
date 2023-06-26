package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwards.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
