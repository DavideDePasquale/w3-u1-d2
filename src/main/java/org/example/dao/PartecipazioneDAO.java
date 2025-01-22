package org.example.dao;

import org.example.entities.Partecipazione;

import javax.persistence.EntityManager;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em){
        this.em =em;
    }
    public void save(Partecipazione partecipazione){
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }
    public Partecipazione getbyID(long id){
        return em.find(Partecipazione.class, id);
    }
    public void remove(Partecipazione partecipazione){
        em.getTransaction().begin();
        em.remove(partecipazione);
        em.getTransaction().commit();
    }


}