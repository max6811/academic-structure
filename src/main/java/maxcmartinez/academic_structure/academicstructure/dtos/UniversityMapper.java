package maxcmartinez.academic_structure.academicstructure.dtos;

import maxcmartinez.academic_structure.academicstructure.models.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityMapper {

    public UniversityDTO toDTO(University university){
        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setUuid(university.getUuid());
        universityDTO.setName(university.getName());
        universityDTO.setCode(university.getCode());
        return universityDTO;
    }
    public University getUniversity(UniversityDTO universityDTO){
        University university = new University();
        university.setUuid(universityDTO.getUuid());
        university.setName(universityDTO.getName());
        university.setCode(universityDTO.getCode());
        return university;
    }
}
