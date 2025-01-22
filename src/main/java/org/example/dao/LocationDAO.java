package org.example.dao;

import org.example.entities.Location;

import javax.persistence.EntityManager;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em){
        this.em =em;
    }
    public void save(Location location){
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }
    public Location getbyID(long id){
        return em.find(Location.class, id);
    }
    public void remove(Location location){
        em.getTransaction().begin();
        em.remove(location);
        em.getTransaction().commit();
    }


}