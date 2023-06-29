package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.hogwards.school.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByNameIgnoreCase(String name);

    //find faculty by color
    Collection<Faculty> findAllByColorIgnoreCase(String color);

}
