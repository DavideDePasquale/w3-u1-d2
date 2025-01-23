package org.example.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Concerto extends Evento{

    private GenereConcerto genere;
    private boolean streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, org.example.entities.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genere, boolean streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.streaming = streaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                '}';
    }
}
