package pl.polsl.lab6.pawel.salicki.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Team table JPA.
 * 
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
public class Team implements Serializable {

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

    private String countryNameTeam;

    private String coachNameTeam;

    /**
     * Get the value of coachNameTeam
     *
     * @return the value of coachNameTeam
     */
    public String getCoachNameTeam() {
        return coachNameTeam;
    }

    /**
     * Set the value of coachNameTeam
     *
     * @param coachNameTeam new value of coachNameTeam
     */
    public void setCoachNameTeam(String coachNameTeam) {
        this.coachNameTeam = coachNameTeam;
    }

    private String nameTeam;

    /**
     * Get the value of nameTeam
     *
     * @return the value of nameTeam
     */
    public String getNameTeam() {
        return nameTeam;
    }

    /**
     * Set the value of nameTeam
     *
     * @param nameTeam new value of nameTeam
     */
    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    /**
     * Get the value of countryNameTeam
     *
     * @return the value of countryNameTeam
     */
    public String getCountryNameTeam() {
        return countryNameTeam;
    }

    /**
     * Set the value of countryNameTeam
     *
     * @param countryNameTeam new value of countryNameTeam
     */
    public void setCountryNameTeam(String countryNameTeam) {
        this.countryNameTeam = countryNameTeam;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.lab6.pawel.salicki.entity.Team[ id=" + id + " ]";
    }
    
}
