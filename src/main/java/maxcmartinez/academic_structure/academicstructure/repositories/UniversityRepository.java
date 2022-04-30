package maxcmartinez.academic_structure.academicstructure.repositories;

import maxcmartinez.academic_structure.academicstructure.dtos.UniversityDTO;
import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//@Repository
//@Transactional //commitea cada transaccion generada si no tiene errores y si no rollback
    //Other method for get data from db with extend JpaRepository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Query("Select u from University u Where u.uuid = ?1")
    University findOneByUuid(String uuid);

//    @Query("UPDATE u FROM University u WHERE u.uuid = ?1")
//    UniversityDTO update(String universityUuid, University university);

//    private static List<University> universityList = new ArrayList<>();
//    private static int idCounter;
//
//    @PersistenceContext //toma los datos de conecion
//    private EntityManager entityManager;
//
//    static {
//        idCounter = 4;
//        universityList.add(new University(1, UUID.randomUUID().toString(), "UNiversidad mayor de san simon", "UMSS", new Date()));
//        universityList.add(new University(2, UUID.randomUUID().toString(), "UNiversidad del valle", "UNIVALLE", new Date()));
//        universityList.add(new University(3, UUID.randomUUID().toString(), "UNiversidad catolica de Bolivia", "UCB", new Date()));
//    }
//
//    public List<University> findAll(){
//        return universityList;
//    }
//
//    public University save(University newUniversity){
//        entityManager.persist(newUniversity);
//        return newUniversity;
//
////        newUniversity.setId(idCounter);
////        newUniversity.setUuid(UUID.randomUUID().toString());
////        universityList.add(newUniversity);
////        idCounter++;
////        return newUniversity;
//    }
//
//    public University findOneByUuid(String uuid){
//        return universityList
//                .stream()//es como un foreach
//                .filter(university -> university.getUuid().equals(uuid))
//                .findAny()
//                .orElse(null);
//    }
//
////    public University findOneByUuid(String uuid){
////        //es como un foreach
////        for (University university : universityList) {
////            if (university.getUuid().equals(uuid)) {
////                return university;
////            }
////        }
////        return null;
////    }
}
