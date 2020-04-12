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
 * about players.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
@Table(name = "PLAYERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p")
    , @NamedQuery(name = "Players.findById", query = "SELECT p FROM Players p WHERE p.id = :id")
    , @NamedQuery(name = "Players.findByFouls", query = "SELECT p FROM Players p WHERE p.fouls = :fouls")
    , @NamedQuery(name = "Players.findByGoals", query = "SELECT p FROM Players p WHERE p.goals = :goals")
    , @NamedQuery(name = "Players.findByIdteam", query = "SELECT p FROM Players p WHERE p.idteam = :idteam")
    , @NamedQuery(name = "Players.findByMinuteentered", query = "SELECT p FROM Players p WHERE p.minuteentered = :minuteentered")
    , @NamedQuery(name = "Players.findByMinuteleft", query = "SELECT p FROM Players p WHERE p.minuteleft = :minuteleft")
    , @NamedQuery(name = "Players.findByName", query = "SELECT p FROM Players p WHERE p.name = :name")
    , @NamedQuery(name = "Players.findByPlayedwholematch", query = "SELECT p FROM Players p WHERE p.playedwholematch = :playedwholematch")
    , @NamedQuery(name = "Players.findByRedcard", query = "SELECT p FROM Players p WHERE p.redcard = :redcard")
    , @NamedQuery(name = "Players.findByYellowcards", query = "SELECT p FROM Players p WHERE p.yellowcards = :yellowcards")})
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Player ID.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    /**
     * Amount of fouls.
     */
    @Column(name = "FOULS")
    private Integer fouls;

    /**
     * Amount of goals.
     */
    @Column(name = "GOALS")
    private Integer goals;

    /**
     * Team ID.
     */
    @Column(name = "IDTEAM")
    private Integer idteam;

    /**
     * Minute entered on match.
     */
    @Column(name = "MINUTEENTERED")
    private Integer minuteentered;

    /**
     * Minute left from match.
     */
    @Column(name = "MINUTELEFT")
    private Integer minuteleft;
    @Size(max = 255)

    /**
     * Name of player.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Boolean if the player played on the whole match.
     */
    @Column(name = "PLAYEDWHOLEMATCH")
    private Boolean playedwholematch;

    /**
     * Boolean if the player got a red card.
     */
    @Column(name = "REDCARD")
    private Boolean redcard;

    /**
     * Amount of yellow cards.
     */
    @Column(name = "YELLOWCARDS")
    private Integer yellowcards;

    public Players() {
    }

    public Players(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getIdteam() {
        return idteam;
    }

    public void setIdteam(Integer idteam) {
        this.idteam = idteam;
    }

    public Integer getMinuteentered() {
        return minuteentered;
    }

    public void setMinuteentered(Integer minuteentered) {
        this.minuteentered = minuteentered;
    }

    public Integer getMinuteleft() {
        return minuteleft;
    }

    public void setMinuteleft(Integer minuteleft) {
        this.minuteleft = minuteleft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlayedwholematch() {
        return playedwholematch;
    }

    public void setPlayedwholematch(Boolean playedwholematch) {
        this.playedwholematch = playedwholematch;
    }

    public Boolean getRedcard() {
        return redcard;
    }

    public void setRedcard(Boolean redcard) {
        this.redcard = redcard;
    }

    public Integer getYellowcards() {
        return yellowcards;
    }

    public void setYellowcards(Integer yellowcards) {
        this.yellowcards = yellowcards;
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
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.lab6.pawel.salicki.entities.Players[ id=" + id + " ]";
    }

}
