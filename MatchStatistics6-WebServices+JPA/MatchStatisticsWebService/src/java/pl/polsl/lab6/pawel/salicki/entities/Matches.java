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
 * about matches.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
@Table(name = "MATCHES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matches.findAll", query = "SELECT m FROM Matches m")
    , @NamedQuery(name = "Matches.findById", query = "SELECT m FROM Matches m WHERE m.id = :id")
    , @NamedQuery(name = "Matches.findByArbiternamematch", query = "SELECT m FROM Matches m WHERE m.arbiternamematch = :arbiternamematch")
    , @NamedQuery(name = "Matches.findByGuestteamid", query = "SELECT m FROM Matches m WHERE m.guestteamid = :guestteamid")
    , @NamedQuery(name = "Matches.findByHostteamid", query = "SELECT m FROM Matches m WHERE m.hostteamid = :hostteamid")
    , @NamedQuery(name = "Matches.findByLengthmatch", query = "SELECT m FROM Matches m WHERE m.lengthmatch = :lengthmatch")})
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Match ID.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    /**
     * Name of main arbiter.
     */
    @Size(max = 255)
    @Column(name = "ARBITERNAMEMATCH")
    private String arbiternamematch;
    
    /**
     * Guest team ID.
     */
    @Column(name = "GUESTTEAMID")
    private Integer guestteamid;
    
    /**
     * Host team ID.
     */
    @Column(name = "HOSTTEAMID")
    private Integer hostteamid;
    
    /**
     * Length of match.
     */
    @Column(name = "LENGTHMATCH")
    private Integer lengthmatch;

    public Matches() {
    }

    public Matches(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArbiternamematch() {
        return arbiternamematch;
    }

    public void setArbiternamematch(String arbiternamematch) {
        this.arbiternamematch = arbiternamematch;
    }

    public Integer getGuestteamid() {
        return guestteamid;
    }

    public void setGuestteamid(Integer guestteamid) {
        this.guestteamid = guestteamid;
    }

    public Integer getHostteamid() {
        return hostteamid;
    }

    public void setHostteamid(Integer hostteamid) {
        this.hostteamid = hostteamid;
    }

    public Integer getLengthmatch() {
        return lengthmatch;
    }

    public void setLengthmatch(Integer lengthmatch) {
        this.lengthmatch = lengthmatch;
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
        if (!(object instanceof Matches)) {
            return false;
        }
        Matches other = (Matches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.lab6.pawel.salicki.entities.Matches[ id=" + id + " ]";
    }
    
}
