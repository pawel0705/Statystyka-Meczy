package pl.polsl.lab6.pawel.salicki.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Arbiters table database.
 * 
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
public class Arbiters implements Serializable {

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

    private String arbitratorName;

    private int arbitratorMatchId;

    /**
     * Get the value of arbitratorMatchId
     *
     * @return the value of arbitratorMatchId
     */
    public int getArbitratorMatchId() {
        return arbitratorMatchId;
    }

    /**
     * Set the value of arbitratorMatchId
     *
     * @param arbitratorMatchId new value of arbitratorMatchId
     */
    public void setArbitratorMatchId(int arbitratorMatchId) {
        this.arbitratorMatchId = arbitratorMatchId;
    }

    /**
     * Get the value of arbitratorName
     *
     * @return the value of arbitratorName
     */
    public String getArbitratorName() {
        return arbitratorName;
    }

    /**
     * Set the value of arbitratorName
     *
     * @param arbitratorName new value of arbitratorName
     */
    public void setArbitratorName(String arbitratorName) {
        this.arbitratorName = arbitratorName;
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
        return "pl.polsl.lab6.pawel.salicki.entity.Arbiters[ id=" + id + " ]";
    }
    
}
