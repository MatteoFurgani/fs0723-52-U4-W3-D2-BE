package entities;

import jakarta.persistence.*;



@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private StatoPartecipazione stato;


    public Partecipazione() {}

    public Partecipazione(Persona persona, Evento evento, Location location, StatoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.location = location;
        this.stato = stato;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }


    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", location=" + location +
                ", stato=" + stato +
                '}';
    }
}
