package dao;

import entities.Persona;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(persona);
        transaction.commit();
        System.out.println("Persona salvata con successo");
    }

    public Persona findById(long id) {
        Persona persona = em.find(Persona.class, id);
        if (persona == null) throw new NotFoundException(id);
        return persona;
    }

    public void findByAndDelete(Persona persona) {
        Persona found = this.findById(persona.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Persona eliminata con successo");
    }
}
