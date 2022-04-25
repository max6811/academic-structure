package maxcmartinez.academic_structure.academicstructure.services;

import maxcmartinez.academic_structure.academicstructure.dtos.UniversityDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.UniversityMapper;
import maxcmartinez.academic_structure.academicstructure.exceptions.NotFoundException;
import maxcmartinez.academic_structure.academicstructure.models.University;
import maxcmartinez.academic_structure.academicstructure.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UniversityMapper universityMapper;


    public List<UniversityDTO> getAllUniversities() {
//        return  Collections.singletonList(new UniversityDTO( UUID.randomUUID().toString(),"UMSS", "Universidad Mayor de San Simon"));

        return universityRepository.findAll()
                .stream()
                .map(university -> universityMapper.toDTO(university))
                .collect(Collectors.toList());
    }

    public UniversityDTO getUniversity(String universityUuid){
        University university = universityRepository.findOneByUuid(universityUuid);
        if(university == null){
            throw new NotFoundException("University", universityUuid);
        }
        return universityMapper.toDTO(university);
    }

    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        return universityMapper.toDTO(universityRepository.save(universityMapper.getUniversity(universityDTO)));
    }
}
