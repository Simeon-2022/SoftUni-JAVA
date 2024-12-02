package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column
    private double area;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country")
    @Column(nullable = false)
    private Set<Attraction> attractions;

    @OneToMany(mappedBy = "country")
    @Column(nullable = false)
     private Set<Visitor> visitors;

    public Country() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }
}
