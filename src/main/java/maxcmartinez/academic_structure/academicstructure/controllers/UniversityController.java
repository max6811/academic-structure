package maxcmartinez.academic_structure.academicstructure.controllers;

import maxcmartinez.academic_structure.academicstructure.dtos.FacultyDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.UniversityDTO;
import maxcmartinez.academic_structure.academicstructure.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/universities")//para no tener codigo duplicado
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<UniversityDTO> getAll(){
        //return  Collections.singletonList(new UniversityDTO( UUID.randomUUID().toString(),"UMSS", "Universidad Mayor de San Simon"));
     return universityService.getAllUniversities();
    }
    @GetMapping("/{universityUuid}")
    public UniversityDTO get(@PathVariable String universityUuid){
//        return new UniversityDTO(universityUuid,"UMSS", "Universidad Mayor de San S");
        return universityService.getUniversity(universityUuid);
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> create(@RequestBody UniversityDTO university) throws URISyntaxException {
//        university.setUuid(UUID.randomUUID().toString());
//        return university;
//        return universityService.saveUniversity(university);
        //forma de enviar status
//        UniversityDTO universityDTO = universityService.saveUniversity(university);
//        return new ResponseEntity(universityDTO, HttpStatus.CREATED);
        //otra forma con status
        UniversityDTO universityDTO = universityService.saveUniversity(university);
//        URI uri = new URI("/universities/"+ universityDTO.getUuid());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{universityUuid}")
                .buildAndExpand(universityDTO.getUuid())
                .toUri();
//        return ResponseEntity
//                .created(uri)
//                .body(universityDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, uri.toString())
                .body(universityDTO);

    }

    @PutMapping("/{universityUuid}")
    public UniversityDTO update(@RequestBody UniversityDTO university){
        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/{universityUuid}")
    public UniversityDTO delete(@PathVariable String universityUuid){
        return universityService.deleteUniversity(universityUuid);
    }

    @GetMapping("/{universityUuid}/faculties")
    public List<FacultyDTO> getFaculties(@PathVariable String universityUuid){
        System.out.println(universityUuid);
        return this.universityService.getFaculties(universityUuid);
    }

}
