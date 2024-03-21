
import dao.EventoDAO;
import dao.PersonaDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import entities.*;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Hello World!");

        EventoDAO eventoDAO = new EventoDAO(em);

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Partita di calcio", 2024, TipoEvento.PUBBLICO, 22, "Roma", "Lazio", 3, 0);
        eventoDAO.save(partitaDiCalcio);

        Concerto concerto = new Concerto("Concerto di rock", 2024, TipoEvento.PRIVATO, 500, GenereConcerto.ROCK, true);
        eventoDAO.save(concerto);

        List<Persona> atleti = new ArrayList<>();
        Persona atleta1 = new Persona("Mario", "Rossi", "mario@email.com", "1990-01-01", Genere.MASCHIO);
        Persona atleta2 = new Persona("Anna", "Bianchi", "anna@email.com", "1992-03-15", Genere.FEMMINA);
        atleti.add(atleta1);
        atleti.add(atleta2);

        em.getTransaction().begin();
        em.persist(atleta1); // Salviamo l'atleta 1
        em.persist(atleta2); // Salviamo l'atleta 2
        em.getTransaction().commit();

        GaraDiAtletica garaDiAtletica = new GaraDiAtletica("Maratona", 2024, TipoEvento.PUBBLICO, 100, atleti, null);
        eventoDAO.save(garaDiAtletica);



        em.close();
        emf.close();
    }
}
