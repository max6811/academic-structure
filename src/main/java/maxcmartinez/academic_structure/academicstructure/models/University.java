package maxcmartinez.academic_structure.academicstructure.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE university SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class University {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(updatable = false, nullable = false, unique = true, length = 36)//validation
    private String uuid;
    @Column(nullable = false, length = 500)
    private String name;
    @Column(nullable = false, length = 20)
    private String code;
    @CreatedDate
    @Column(updatable = false, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")//puedes poner en una variable global
    private Date createdDate;
    @LastModifiedDate
    @Column(updatable = true, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedDate;
//    @CreatedBy //para inicar cual es el usuario que hizo la creacion
//    @LastModifiedBy //Injecta el usuario que hizo la modificacion
//    private User createdBy;
    //por defecto la declaracion en ONETOMANY es LAZY
    @OneToMany(mappedBy = "university", cascade = CascadeType.REMOVE)//el atributo debe ser igual que que en la clase (Faculty)
    private List<Faculty> facultyList;
    @Column( columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")//para que inicie con un valor false por defecto
    private boolean deleted;

    public University(){

    }

    public University(Integer id){
        this.id = id;
    }

    public University(String uuid){
        this.uuid = uuid;
    }

    public University(Integer id, String uuid, String name, String code, Date createDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createdDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    //creamos un hook para uuid
    @PrePersist
    public void initializeUuid(){
        this.setUuid(UUID.randomUUID().toString());
    }
}
