
import dao.EventoDAO;
import dao.PersonaDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import entities.*;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        try {

            Persona persona = new Persona("Mario", "Rossi", "mario.rossi@example.com", "1990-01-01", Genere.MASCHIO);
            personaDAO.save(persona);


            Location location = new Location("Villa Bella", "Roma");
            locationDAO.save(location);

            Evento evento = new Evento("Festa di Compleanno", 2024, TipoEvento.PRIVATO, 50);
            eventoDAO.save(evento);

            Partecipazione partecipazione = new Partecipazione(persona, evento, location, StatoPartecipazione.CONFERMATO);
            partecipazioneDAO.save(partecipazione);
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio delle entità: " + e.getMessage());
        }


        try {

            Evento eventoRecuperato = eventoDAO.findById(1);
            System.out.println("Evento recuperato: " + eventoRecuperato);


            Partecipazione partecipazioneRecuperata = partecipazioneDAO.findById(1);
            System.out.println("Partecipazione recuperata: " + partecipazioneRecuperata);
        } catch (NotFoundException e) {
            System.out.println("Entità non trovata: " + e.getMessage());
        }

        em.close();
        emf.close();
    }
}
