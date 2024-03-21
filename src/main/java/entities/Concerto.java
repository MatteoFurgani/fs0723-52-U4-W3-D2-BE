package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(name = "genere")
    private GenereConcerto genere;

    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto() {}

    public Concerto(String titolo, int dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
