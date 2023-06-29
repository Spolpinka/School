package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwards.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findAllByAge(int age);

    List<Student> findAllByAgeBetween(int min, int max);
}
