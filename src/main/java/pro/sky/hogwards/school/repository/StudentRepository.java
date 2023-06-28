package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwards.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long>{

    //find student by age between min and max
    //find student by age between min and max
    Collection<Student> findByAgeBetween(int min, int max);
}
