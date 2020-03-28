package pl.bykowski.springdataexample;

import javax.persistence.*;

@Entity
@Table(name="CarsDB")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String mark;

    //@Transient - wtedy nie zapisuje wartości w bazie danych
    private String model;

    @Enumerated(EnumType.STRING) // zapisuje do bazy danych stringa z enuma, zamiast numeru
    private Color color;

    private String registrationNumber;

    public Car(String mark, String model, Color color, String registrationNumber) {
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getRegistrationNumber() { return registrationNumber; }

    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

}
