package maxcmartinez.academic_structure.academicstructure.dtos;

import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    @Autowired
    private UniversityMapper universityMapper;

    public FacultyDTO toDTO(Faculty faculty, boolean mapUniversity){
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setUuid(faculty.getUuid());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setCode(faculty.getCode());
        if (mapUniversity){
            facultyDTO.setUniversity(universityMapper.toDTO(faculty.getUniversity()));
        }
        return facultyDTO;
    }

    public Faculty getFaculty(FacultyDTO facultyDTO, University university){
        Faculty faculty = new Faculty();
        faculty.setUuid(facultyDTO.getUuid());
        faculty.setName(facultyDTO.getName());
        faculty.setCode(facultyDTO.getCode());
        faculty.setUniversity(university);
        return faculty;
    }
}
