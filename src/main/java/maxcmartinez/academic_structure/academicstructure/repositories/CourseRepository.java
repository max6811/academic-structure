package maxcmartinez.academic_structure.academicstructure.repositories;

import maxcmartinez.academic_structure.academicstructure.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
