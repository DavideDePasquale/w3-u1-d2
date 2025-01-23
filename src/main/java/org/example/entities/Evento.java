package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "evento") //mettila sempre al plurale d'ora in poi!!
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Evento {

    @Id
    @GeneratedValue //come il SERIAL in PostgreSQL
    private Long id;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(length = 100, nullable = false)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;
    @Column(name = "numero_max_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaPartecipazioni;


    public Evento() {
        //verrà utilizzato da Postgres
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, org.example.entities.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
        this.listaPartecipazioni = new ArrayList<Partecipazione>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
