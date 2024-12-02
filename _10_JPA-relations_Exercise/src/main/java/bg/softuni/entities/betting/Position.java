package bg.softuni.entities.betting;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Enumerated(EnumType.STRING)
    private PositionEnum id;

    @Basic
    private String description;

    //@OneToMany(mappedBy = "position")
    //private List<Player> player;

    public Position(){
      //  this.player = new ArrayList<>();
    }


    public Position(PositionEnum id, String description) {

        this.id = id;
        this.description = description;
    }
}
