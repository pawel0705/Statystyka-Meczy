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
 * about teams.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
@Table(name = "TEAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    , @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id")
    , @NamedQuery(name = "Team.findByCoachnameteam", query = "SELECT t FROM Team t WHERE t.coachnameteam = :coachnameteam")
    , @NamedQuery(name = "Team.findByCountrynameteam", query = "SELECT t FROM Team t WHERE t.countrynameteam = :countrynameteam")
    , @NamedQuery(name = "Team.findByNameteam", query = "SELECT t FROM Team t WHERE t.nameteam = :nameteam")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Team ID.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    /**
     * Coach name of team.
     */
    @Size(max = 255)
    @Column(name = "COACHNAMETEAM")
    private String coachnameteam;

    /**
     * Country name of team.
     */
    @Size(max = 255)
    @Column(name = "COUNTRYNAMETEAM")
    private String countrynameteam;

    /**
     * Name of team.
     */
    @Size(max = 255)
    @Column(name = "NAMETEAM")
    private String nameteam;

    public Team() {
    }

    public Team(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoachnameteam() {
        return coachnameteam;
    }

    public void setCoachnameteam(String coachnameteam) {
        this.coachnameteam = coachnameteam;
    }

    public String getCountrynameteam() {
        return countrynameteam;
    }

    public void setCountrynameteam(String countrynameteam) {
        this.countrynameteam = countrynameteam;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
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
        return "pl.polsl.lab6.pawel.salicki.entities.Team[ id=" + id + " ]";
    }

}
