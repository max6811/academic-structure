package maxcmartinez.academic_structure.academicstructure.controllers;

import maxcmartinez.academic_structure.academicstructure.dtos.FacultyDTO;
import maxcmartinez.academic_structure.academicstructure.models.Faculty;
import maxcmartinez.academic_structure.academicstructure.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public List<FacultyDTO> getAll(){
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{facultyUuid}")
    public FacultyDTO get(@PathVariable String facultyUuid){
        return facultyService.findByUuid(facultyUuid);
    }

    @PostMapping
    public FacultyDTO create(@RequestBody FacultyDTO facultyDTO){
        return facultyService.saveFaculty(facultyDTO);
    }
}
