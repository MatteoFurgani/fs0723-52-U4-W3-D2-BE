package dao;

import entities.Evento;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getId() + " salvato con successo");
    }

    public Evento findById(long evento_id) {
        Evento evento = em.find(Evento.class, evento_id);
        if (evento == null) throw new NotFoundException(evento_id);
        return evento;
    }

    public void findByIdAndDelete(long evento_id) {
        Evento found = this.findById(evento_id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Evento " + found.getId() + " eliminato con successo");
    }
}

