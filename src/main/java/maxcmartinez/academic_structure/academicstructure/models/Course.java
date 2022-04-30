package maxcmartinez.academic_structure.academicstructure.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonIgnore // para que no genere un ciclo infinito
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;

    public Course(){

    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String course1) {
        this.name = course1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
