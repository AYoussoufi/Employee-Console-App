package entity;

import java.util.Date;

public class Analyste extends Employee{

    private Integer numberOfClients ;

    public Analyste(int id,String firstName, String lastName,String dateEmbauche,Integer numberOfClients){
        super(id,firstName,lastName,dateEmbauche);
        this.numberOfClients = numberOfClients;
    }

    public Analyste(int id,String firstName, String lastName,Integer numberOfClients){
        super(id,firstName,lastName);
        this.numberOfClients = numberOfClients;
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(Integer numberOfClients) {
        this.numberOfClients = numberOfClients;
    }


    @Override
    public String toString() {
        return "Analyste"
                +";"+this.getId()
                +";"+this.getLastName()
                +";"+this.getLastName()
                +";"+this.getDateEmbauche()+
                ";"+ this.getNumberOfClients()+";";
    }
}
