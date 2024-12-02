package bg.softuni.entities.geo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Enumerated(EnumType.STRING)
    private countryIsoCodes id;

    @Basic(optional = false)
    private String name;

    @ManyToMany
    private Set<Continent> continents;

    public Country() {
        this.continents = new HashSet<>();
    }


}
