package bg.softuni.entities.betting;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    private String name;

    @Column(name = "squad_number", nullable = false)
    private int squadNumber;

    @ManyToOne
    private Position position;

    @Column(name = "is_injured", nullable = false)
    private boolean isInjured;

    //private Team team;

    public Player(){}

}
