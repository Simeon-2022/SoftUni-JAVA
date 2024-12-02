package bg.softuni.entities.sales;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String name;

    @Basic()
    private String email;

    @Column(name = "credit_card_number", length = 50,nullable = false, unique = true)
    private String creditCardNumber;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> orders;

    public Set<Sale> getOrders() {
        return orders;
    }

    public void setOrders(Set<Sale> orders) {
        this.orders = orders;
    }

    public Customer() {
        this.orders = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
