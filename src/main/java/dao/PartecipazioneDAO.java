package dao;

import entities.Partecipazione;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione salvata con successo");
    }

    public Partecipazione findById(long id) {
        Partecipazione partecipazione = em.find(Partecipazione.class, id);
        if (partecipazione == null) throw new NotFoundException("Partecipazione non trovata" + id);
        return partecipazione;
    }

    public void findByAndDelete(Partecipazione partecipazione) {
        Partecipazione found = this.findById(partecipazione.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Partecipazione eliminata con successo");
    }
}

