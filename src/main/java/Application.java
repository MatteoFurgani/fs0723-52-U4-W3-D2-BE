
import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);


      /*  Evento evento1 = new Evento(1, "Festa di Natale", 12, TipoEvento.PRIVATO, 100);
        Evento evento2 = new Evento(2, "Festa di Pasqua", 01, TipoEvento.PRIVATO, 75);
        Evento evento3 = new Evento(3, "Festa di Capodanno", 31, TipoEvento.PRIVATO, 145); */

      /*  ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3); */

        try{
            Evento evento1 = ed.findById(1);
            System.out.println(evento1);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            ed.findByIdAndDelete(3);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }





        System.out.println("Hello World");

        em.close();
        emf.close();
}
}
