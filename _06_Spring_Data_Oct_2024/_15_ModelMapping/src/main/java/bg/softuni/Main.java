package bg.softuni;

import bg.softuni.entities.Address;
import bg.softuni.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("Sofia", "BG");
        Employee employee = new Employee("Simo", "Alexandro", BigDecimal.valueOf(1123.33), LocalDate.of(1985,8,19),address);
        ModelMapper modelMapper = new ModelMapper();






    }
}
