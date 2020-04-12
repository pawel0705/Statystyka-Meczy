package pl.polsl.lab6.pawel.salicki.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Matches table JPA.
 * 
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private int lengthMatch;

    private String arbiterNameMatch;

    private int hostTeamId;

    private int guestTeamId;

    /**
     * Get the value of guestTeamId
     *
     * @return the value of guestTeamId
     */
    public int getGuestTeamId() {
        return guestTeamId;
    }

    /**
     * Set the value of guestTeamId
     *
     * @param guestTeamId new value of guestTeamId
     */
    public void setGuestTeamId(int guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    /**
     * Get the value of hostTeamId
     *
     * @return the value of hostTeamId
     */
    public int getHostTeamId() {
        return hostTeamId;
    }

    /**
     * Set the value of hostTeamId
     *
     * @param hostTeamId new value of hostTeamId
     */
    public void setHostTeamId(int hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    /**
     * Get the value of arbiterNameMatch
     *
     * @return the value of arbiterNameMatch
     */
    public String getArbiterNameMatch() {
        return arbiterNameMatch;
    }

    /**
     * Set the value of arbiterNameMatch
     *
     * @param arbiterNameMatch new value of arbiterNameMatch
     */
    public void setArbiterNameMatch(String arbiterNameMatch) {
        this.arbiterNameMatch = arbiterNameMatch;
    }

    /**
     * Get the value of lengthMatch
     *
     * @return the value of lengthMatch
     */
    public int getLengthMatch() {
        return lengthMatch;
    }

    /**
     * Set the value of lengthMatch
     *
     * @param lengthMatch new value of lengthMatch
     */
    public void setLengthMatch(int lengthMatch) {
        this.lengthMatch = lengthMatch;
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
        return "pl.polsl.lab6.pawel.salicki.entity.Matches[ id=" + id + " ]";
    }
    
}
