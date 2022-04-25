package maxcmartinez.academic_structure.academicstructure.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UniversityDTO {
    @JsonIgnore
    private Long id;
    private String uuid;
    private String code;
    private String name;

    public UniversityDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }
    public UniversityDTO(){}


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
