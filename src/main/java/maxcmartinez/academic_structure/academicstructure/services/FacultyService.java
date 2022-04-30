package maxcmartinez.academic_structure.academicstructure.services;

import maxcmartinez.academic_structure.academicstructure.dtos.FacultyDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.FacultyMapper;
import maxcmartinez.academic_structure.academicstructure.dtos.UniversityDTO;
import maxcmartinez.academic_structure.academicstructure.exceptions.NotFoundException;
import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.models.University;
import maxcmartinez.academic_structure.academicstructure.repositories.FacultyRepository;
import maxcmartinez.academic_structure.academicstructure.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private FacultyMapper facultyMapper;


    public List<FacultyDTO> getAllFaculties() {
        return facultyRepository.findAll()
                        .stream()
                        .map(faculty -> facultyMapper.toDTO(faculty, true))
                        .collect(Collectors.toList());
    }

    public FacultyDTO saveFaculty(FacultyDTO facultyDTO) {
        UniversityDTO universityDTO = facultyDTO.getUniversity();//para verificar que tenga su uuid de University
        if (universityDTO == null){
            throw new NotFoundException("University", null);
        }
        University university = universityRepository.findOneByUuid(universityDTO.getUuid());
        if (university == null){
            throw new NotFoundException("University", universityDTO.getUuid());
        }

        Faculty faculty = facultyMapper.getFaculty(facultyDTO, university);
//        faculty.setUniversity(university);
        facultyRepository.save(faculty);
        //primero convierte a un Entity y el return lo convierte a DTO para mostrar
        return facultyMapper.toDTO(faculty, true);
    }

    public FacultyDTO findByUuid(String facultyUuid) {
       Faculty faculty = facultyRepository.findOneByUuid(facultyUuid);
        if (faculty == null){
            throw new NotFoundException("Faculty", null);
        }
        return facultyMapper.toDTO(faculty, true);
    }
}
