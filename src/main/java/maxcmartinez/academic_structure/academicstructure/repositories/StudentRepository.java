package maxcmartinez.academic_structure.academicstructure.repositories;

import maxcmartinez.academic_structure.academicstructure.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
