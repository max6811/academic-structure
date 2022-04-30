package maxcmartinez.academic_structure.academicstructure.repositories;

import maxcmartinez.academic_structure.academicstructure.dtos.FacultyDTO;
import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {

//    @Query("SELECT f FROM Faculty f WHERE f.uuid = ?1")
    @Query("select f from Faculty f where f.uuid = ?1")
    Faculty findOneByUuid(String facultyUuid);

//    @Query("Select f from Faculty f where f.university = ?1")
//    List<Faculty> findAllByUniversityId(University university);

//    @Query(value = "SELECT * FROM Faculty f WHERE f.university_id = ?1", nativeQuery = true)
//    List<Faculty> findAllByUniversityId(University university);
}
