package maxcmartinez.academic_structure.academicstructure.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class GroupDTO {
    @JsonIgnore
    private Long id;
    private String uuid;
    private String code;
    private String name;
    private ProfessorDTO professorDTO;
    private List<ScheduleDTO> scheduleDTO;
    private SubjectDTO subjectDTO;

    public GroupDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }
    public GroupDTO(){}

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public List<ScheduleDTO> getScheduleDTO() {
        return scheduleDTO;
    }

    public void setScheduleDTO(List<ScheduleDTO> scheduleDTO) {
        this.scheduleDTO = scheduleDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public ProfessorDTO getProfessorDTO() {
        return professorDTO;
    }

    public void setProfessorDTO(ProfessorDTO professorDTO) {
        this.professorDTO = professorDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
