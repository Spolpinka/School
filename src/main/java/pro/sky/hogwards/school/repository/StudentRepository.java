package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.hogwards.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long>{
//find all students by age
    Collection<Student> findAllByAge(int age);

    //find student by age between min and max
    Collection<Student> findByAgeBetween(int min, int max);

    //query method to get count of students in DB
    @Query(value = "SELECT COUNT(id) FROM student", nativeQuery = true)
    int getCountOfStudents();

    //query method to get average age of students in DB
    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    double getAverageAgeOfStudents();

    //get 5 youngest students
    @Query(value = "SELECT * FROM student ORDER BY age LIMIT 5", nativeQuery = true)
    Collection<Student> getFiveYoungestStudents();
}
