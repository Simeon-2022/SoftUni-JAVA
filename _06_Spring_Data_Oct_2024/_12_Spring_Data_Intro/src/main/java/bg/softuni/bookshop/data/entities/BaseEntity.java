package bg.softuni.bookshop.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected BaseEntity(){}

    public long getId() {
        return id;
    }
}
