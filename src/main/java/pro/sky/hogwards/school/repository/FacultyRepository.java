package pro.sky.hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwards.school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
