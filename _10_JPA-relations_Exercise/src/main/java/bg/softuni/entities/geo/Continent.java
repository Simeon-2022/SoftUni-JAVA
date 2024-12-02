package bg.softuni.entities.geo;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    private String name;

    @ManyToOne
    private Country country;

    public Continent(){}

}
