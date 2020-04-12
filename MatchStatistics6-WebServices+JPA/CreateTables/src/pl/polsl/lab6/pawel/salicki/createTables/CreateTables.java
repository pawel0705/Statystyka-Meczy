package pl.polsl.lab6.pawel.salicki.createTables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.polsl.lab6.pawel.salicki.entity.Arbiters;
import pl.polsl.lab6.pawel.salicki.entity.Matches;
import pl.polsl.lab6.pawel.salicki.entity.Players;
import pl.polsl.lab6.pawel.salicki.entity.Team;

/**
 * Servlet creates tables for the JPA database.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class CreateTables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arbiters arbiters = new Arbiters();
        Matches matches = new Matches();
        Players players = new Players();
        Team team = new Team();

        CreateTables createTables = new CreateTables();
        createTables.persist(arbiters);
        createTables.persist(matches);
        createTables.persist(players);
        createTables.persist(team);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreateTablesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
