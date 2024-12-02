package bg.softuni.entities.vehicle;

import jakarta.persistence.*;

@Entity
//@Table(name = "cars")
@DiscriminatorValue("CAR")
public class Car extends Vehicle{

    @Column(name = "paint_code")
    public String paintCode;

    public Car() {
        super("CAR", 5);
    }

    public String getPaintCode() {
        return paintCode;
    }

    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode;
    }
}
