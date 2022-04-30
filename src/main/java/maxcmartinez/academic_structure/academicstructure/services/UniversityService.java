package maxcmartinez.academic_structure.academicstructure.services;

import maxcmartinez.academic_structure.academicstructure.dtos.FacultyDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.FacultyMapper;
import maxcmartinez.academic_structure.academicstructure.dtos.UniversityDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.UniversityMapper;
import maxcmartinez.academic_structure.academicstructure.exceptions.NotFoundException;
import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.models.University;
import maxcmartinez.academic_structure.academicstructure.repositories.FacultyRepository;
import maxcmartinez.academic_structure.academicstructure.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UniversityMapper universityMapper;
    @Autowired
    private FacultyMapper facultyMapper;
    @Autowired
    private FacultyRepository facultyRepository;


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
//        return universityMapper.toDTO(universityRepository.save(universityMapper.getUniversity(universityDTO)));
        return universityMapper.toDTO(universityRepository.save(universityMapper.toUniversity(universityDTO)));
    }

    public UniversityDTO updateUniversity(UniversityDTO universityDTO) {
        University example1 = new University(universityDTO.getUuid());
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));

        if (optionalUniversity.isEmpty()){
            throw new NotFoundException("University", universityDTO.getUuid());
        }

        University university = optionalUniversity.get();
        university.setCode(universityDTO.getCode());
        university.setName((universityDTO.getName()));
        universityRepository.save(university);
        return universityMapper.toDTO(university);
    }

    public UniversityDTO deleteUniversity(String universityUuid) {
        University example = new University(universityUuid);
        Optional<University> universityOptional = universityRepository.findOne(Example.of(example));
        if(universityOptional.isEmpty()){
            throw new NotFoundException("University", universityUuid);
        }
        University university = universityOptional.get();
        universityRepository.delete(university);
        return universityMapper.toDTO(university);
    }

    public List<FacultyDTO> getFaculties(String universityUuid) {
        //otra forma con (OPTIONAL y EXAMPLE)
        University example1 = new University();
        example1.setUuid(universityUuid);
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));
        if (optionalUniversity.isEmpty()){
            throw new NotFoundException("University", universityUuid);
        }
        University university = optionalUniversity.get();

//        University university = universityRepository.findOneByUuid(universityUuid);
//        if (university == null){
//            throw new NotFoundException("University", universityUuid);
//        }
//        List<Faculty> faculties = facultyRepository.findAllByUniversityId(university);

        //otra forma con un objeto seteando lo que quiero que compare
        Faculty example = new Faculty();
        University universityExample = new University();
        universityExample.setId(university.getId());
        example.setUniversity(universityExample);
        List<Faculty> faculties = facultyRepository.findAll(Example.of(example));

        return faculties
                .stream()
                .map(faculty -> facultyMapper.toDTO(faculty, true))
                .collect(Collectors.toList());
    }
}
