package bg.softuni.entities.hospital;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    //first name, last name, address, email, date of birth, picture, information on whether he has medical insurance or not

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Basic
    private String address;

    @Basic
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @OneToMany(mappedBy = "patient")
    private List<Visitation> visitations;

    @OneToMany
    private Set<Diagnosis> diagnoses;

    @ManyToMany
    private Set<Medicament> medicaments;

    public Patient() {
        this.visitations = new ArrayList<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }


}
