package dao;

import entities.Location;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(location);
        transaction.commit();
        System.out.println("Location salvata con successo");
    }

    public Location findById(long id) {
        Location location = em.find(Location.class, id);
        if (location == null) throw new NotFoundException(id);
        return location;
    }

    public void findByIdAndDelete(Location location) {
        Location found = this.findById(location.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Location eliminata con successo");
    }
}
