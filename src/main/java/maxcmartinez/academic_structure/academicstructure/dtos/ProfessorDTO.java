package maxcmartinez.academic_structure.academicstructure.dtos;

public class ProfessorDTO {
    private String lastname;
    private String firstName;
    private String uuid;

    public ProfessorDTO(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastname = lastName;
    }

    public ProfessorDTO(){}

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
