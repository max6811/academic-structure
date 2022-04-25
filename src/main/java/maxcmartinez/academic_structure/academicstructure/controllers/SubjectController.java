package maxcmartinez.academic_structure.academicstructure.controllers;

import maxcmartinez.academic_structure.academicstructure.dtos.GroupDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.ProfessorDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.ScheduleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class SubjectController {

    @GetMapping("/subjects/{subjectUuid}/groups")
    public List<GroupDTO> getAll(@PathVariable String subjectUuid){
        GroupDTO groupDTO = new GroupDTO(UUID.randomUUID().toString(),"INTRO", "Introduccion a la programacion");
        groupDTO.setProfessorDTO(new ProfessorDTO(UUID.randomUUID().toString(), "Maxi", "martinez"));
        groupDTO.setScheduleDTO(Collections.singletonList(new ScheduleDTO("Monday", "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }
}
