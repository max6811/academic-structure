package maxcmartinez.academic_structure.academicstructure.controllers;

import maxcmartinez.academic_structure.academicstructure.dtos.GroupDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.ProfessorDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.ScheduleDTO;
import maxcmartinez.academic_structure.academicstructure.dtos.SubjectDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ProfessorController {

    @GetMapping("/professors/{professorUuid}/groups")
    public List<GroupDTO> getAllGroups(@PathVariable String professorUuid ){
        GroupDTO groupDTO = new GroupDTO(UUID.randomUUID().toString(),"INTRO", "Introduccion a la programacion");
        groupDTO.setSubjectDTO(new SubjectDTO(UUID.randomUUID().toString(), "Maxi", "martinez"));
        groupDTO.setScheduleDTO(Collections.singletonList(new ScheduleDTO("Monday", "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }
    @PostMapping("/professors/{professorUuid}/groups")
    public GroupDTO getAllGroups(@PathVariable String professorUuid, @RequestBody GroupDTO group){
        group.setUuid(UUID.randomUUID().toString());
        group.setProfessorDTO(new ProfessorDTO(group.getUuid(), "Maxi", "martinez"));
        group.setSubjectDTO(new SubjectDTO(group.getUuid(), "Maxi", "martinez"));
        return group;
    }
}
