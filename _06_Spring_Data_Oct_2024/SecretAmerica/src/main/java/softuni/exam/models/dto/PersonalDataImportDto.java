package softuni.exam.models.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@XmlRootElement(name = "personal_data")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataImportDto {

    @XmlElement
    @Min(value = 1)
    @Max(value = 100)
    private int age;

    @XmlElement
    @Pattern(regexp = "M|F")
    private String gender;

    @XmlElement(name = "birth_date")
    @Past()
    private LocalDate birthDate;

    @XmlElement(name = "card_number")
    @Length(min = 9,max = 9)
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public @Past() LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
