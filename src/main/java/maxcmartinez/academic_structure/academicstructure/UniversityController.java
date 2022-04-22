package maxcmartinez.academic_structure.academicstructure;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class UniversityController {

    @GetMapping("/universities")
    public List<University> getAll(){
        return  Collections.singletonList(new University( UUID.randomUUID().toString(),"UMSS", "Universidad Mayor de San Simon"));
    }
    @GetMapping("/universities/{universityUuid}")
    public University get(@PathVariable String universityUuid){
        return new University(universityUuid,"UMSS", "Universidad Mayor de San S");
    }

    @PostMapping("/universities")
    public University create(@RequestBody University university){
        university.setUuid(UUID.randomUUID().toString());
        return university;
    }

    @PutMapping("/universities/{universityUuid}")
    public University edit(@PathVariable String universityUuid, University university){
        return new University(universityUuid, "UMSS", "Universidad Mayor de San S");
    }

    @DeleteMapping("/universities/{universityUuid}")
    public University delete(@PathVariable String universityUuid){
        return new University(universityUuid, "UMSS", "Universidad Mayor de San S");
    }

}
