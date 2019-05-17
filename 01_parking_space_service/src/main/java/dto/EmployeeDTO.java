package dto;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "EMPLOYEE")
@Access(AccessType.FIELD)
public class EmployeeDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_from_account_db", nullable = false)
    private Integer externalId;

    @OneToMany(mappedBy="employee")
    private Set<ZoneDTO> zones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer external_id) {
        this.externalId = external_id;
    }

    public Set<ZoneDTO> getZones() {
        return zones;
    }

    public void setZones(Set<ZoneDTO> zones) {
        this.zones = zones;
    }
}
