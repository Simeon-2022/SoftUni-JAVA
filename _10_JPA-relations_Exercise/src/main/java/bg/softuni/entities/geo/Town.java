package bg.softuni.entities.geo;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @ManyToOne
    private Country country;

    public Town(){}
}


