package softuni.exam.models.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "attractions")
public class Attraction extends BaseEntity{


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int elevation;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id",nullable = false)
    private Country country;

    @OneToMany(mappedBy = "attraction")
    @Column(nullable = false)
    private Set<Visitor> visitors;

    public Attraction() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
