package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "visitors")
public class Visitor extends BaseEntity{

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id",referencedColumnName = "id",nullable = false)
    private PersonalData personalData;

    @ManyToOne
    @JoinColumn(name = "attraction_id", referencedColumnName = "id",nullable = false)
    private Attraction attraction;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id",nullable = false)
    private Country country;


    public Visitor() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }
}
