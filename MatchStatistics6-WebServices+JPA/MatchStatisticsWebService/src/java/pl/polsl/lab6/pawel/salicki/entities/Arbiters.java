package pl.polsl.lab6.pawel.salicki.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class that symbolizes the JPA database table (Entity). Stores information
 * about match referee's helpers.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
@Table(name = "ARBITERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arbiters.findAll", query = "SELECT a FROM Arbiters a")
    , @NamedQuery(name = "Arbiters.findById", query = "SELECT a FROM Arbiters a WHERE a.id = :id")
    , @NamedQuery(name = "Arbiters.findByArbitratormatchid", query = "SELECT a FROM Arbiters a WHERE a.arbitratormatchid = :arbitratormatchid")
    , @NamedQuery(name = "Arbiters.findByArbitratorname", query = "SELECT a FROM Arbiters a WHERE a.arbitratorname = :arbitratorname")})
public class Arbiters implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Arbiter ID.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    /**
     * Match ID.
     */
    @Column(name = "ARBITRATORMATCHID")
    private Integer arbitratormatchid;
    
    /**
     * Name of arbiter.
     */
    @Size(max = 255)
    @Column(name = "ARBITRATORNAME")
    private String arbitratorname;

    public Arbiters() {
    }

    public Arbiters(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getArbitratormatchid() {
        return arbitratormatchid;
    }

    public void setArbitratormatchid(Integer arbitratormatchid) {
        this.arbitratormatchid = arbitratormatchid;
    }

    public String getArbitratorname() {
        return arbitratorname;
    }

    public void setArbitratorname(String arbitratorname) {
        this.arbitratorname = arbitratorname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbiters)) {
            return false;
        }
        Arbiters other = (Arbiters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.lab6.pawel.salicki.entities.Arbiters[ id=" + id + " ]";
    }

}
