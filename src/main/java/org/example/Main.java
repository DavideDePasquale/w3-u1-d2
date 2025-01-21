package org.example;

import org.example.entities.Evento;
import org.example.entities.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class Main 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("w3_u1_d2project");
    private static EntityManager em = emf.createEntityManager();
    public static void main( String[] args ) {
      Evento evento1 = new Evento("Festa di Carnevale", LocalDate.of(2025,01,20),"Festa a tema, entrata obbligatoria con la maschera", tipoEvento.PUBBLICO,132);
      Evento evento2 = new Evento("Diciottesimo Carlo", LocalDate.of(2025,06,05),"Festa di compleanno",tipoEvento.PRIVATO,55);
      Evento evento3 = new Evento("Nozze d'Oro Elisa e Mauro", LocalDate.of(2025,03,25),"Festa anniversario matrimonio",tipoEvento.PRIVATO,28);
      Evento evento4 = new Evento("Compleanno Davide", LocalDate.of(2026,06,05),"Festa di compleanno",tipoEvento.PRIVATO,60);
      Evento evento5 = new Evento("Festa Aziendale PAPPAPPERO SRL", LocalDate.of(2025,05,10),"Festa Aziendale",tipoEvento.PRIVATO,267);
      Evento evento6 = new Evento("Concerto Nino D'Angelo", LocalDate.of(2025,12,23),"Concerto Nino D'Angelo",tipoEvento.PUBBLICO,1000);
//      save(evento1);
//      save(evento2);
//      save(evento3);
//      save(evento4);
//      save(evento5);
//      save(evento6);
        Evento ev = find(7);
    remove(ev);
    em.close();
    emf.close();
    }
    public static void save(Evento evento){
        em.getTransaction().begin();
        Evento eventoEsistente = em.find(Evento.class, evento.getId());
        if(eventoEsistente == null){
            em.persist(evento);
        }
        em.getTransaction().commit();
    }
    public static Evento find(long id){
        em.getTransaction().begin();
        Evento evento = em.find(Evento.class, id);
        em.getTransaction().commit();
        return evento;
    }
    public static void remove(Evento evento){
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }
}
