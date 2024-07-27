package _09_Interfaces_and_Abstraction_Lab.carShop;

import java.io.Serializable;

public interface Car extends Serializable {

    Integer TYRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String getCountryProduced();

}
