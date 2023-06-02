package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String dateEmbauche = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public Employee(int id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(int id,String firstName, String lastName,String dateEmbauche) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateEmbauche = dateEmbauche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

     public abstract String toString();
}
