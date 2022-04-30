package maxcmartinez.academic_structure.academicstructure.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)//para generar los audits de @CreateDate
@SQLDelete(sql = "UPDATE faculty SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Faculty {
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
    @Column(updatable = false, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @LastModifiedDate
    @Column(updatable = true, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedDate;
    //    @ManyToOne(fetch = FetchType.EAGER)//intentara cargar la faculad y despues university, ciclo infinito y debe tener un LAZY
    @ManyToOne(fetch = FetchType.LAZY)//LAZY no lo carga por defecto salvo que yo le diga y por defecto es EAGER
    private University university;
    @Column( columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")//para que inicie con un valor false por defecto
    private boolean deleted;

    public Faculty(){}

    public Faculty(Integer id){
        this.id = id;
    }

    public Faculty(String uuid){
        this.uuid = uuid;
    }

    public Faculty(Integer id, String uuid, String name, String code, Date createdDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createdDate = createdDate;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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
