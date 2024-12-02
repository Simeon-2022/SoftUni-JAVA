package bg.softuni.entities.composition;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "ingredients", targetEntity = Shampoo.class)
    private List<Shampoo> shampoos;

    public Ingredient(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
