package entity;

import java.util.Date;

public class Concepteur extends Employee {

    private int yearsOfExperience;

    public Concepteur(int id,String firstName, String lastName, String dateEmbauche, Integer yearsOfExperience) {
        super(id,firstName, lastName,dateEmbauche);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Concepteur(int id,String firstName, String lastName, Integer yearsOfExperience) {
        super(id,firstName, lastName);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Concepteur"
                +";"+this.getId()
                +";"+this.getFirstName()
                +";"+this.getLastName()
                +";"+this.getDateEmbauche()
                +";"+this.getYearsOfExperience();
    }
}
