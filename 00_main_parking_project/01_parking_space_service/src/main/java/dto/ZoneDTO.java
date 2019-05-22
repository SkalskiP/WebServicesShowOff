package dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "ZONE")
@Access(AccessType.FIELD)
public class ZoneDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonBackReference
    private EmployeeDTO employee;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="zone")
    @JsonManagedReference
    private Set<StreetDTO> streets;

    @Override
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public Set<StreetDTO> getStreets() {
        return streets;
    }

    public void setStreets(Set<StreetDTO> streets) {
        this.streets = streets;
    }
}
