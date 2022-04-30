package maxcmartinez.academic_structure.academicstructure.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import maxcmartinez.academic_structure.academicstructure.models.University;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class FacultyDTO {
    @JsonIgnore
    private Long id;

    private String uuid;
    private String name;
    private String code;
    private UniversityDTO university;

    public FacultyDTO(){

    }

    public FacultyDTO(String uuid, String name, String code, University university) {
        this.uuid = uuid;
        this.name = name;
        this.code = code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }
}
