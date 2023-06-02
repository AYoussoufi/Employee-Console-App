package data;

import entity.Analyste;
import entity.Concepteur;
import entity.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    String csvFile = "C:\\Users\\LUCAS 3\\Desktop\\ConsolProject\\src\\data\\employees.csv";
    String tempCsvFile = "C:\\Users\\LUCAS 3\\Desktop\\ConsolProject\\src\\data\\tempemployees.csv";

    public void addObjectIntoThefile(Employee employee) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true));
            writer.write(employee.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeTargetedObjectFromTheFile(String id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            BufferedReader reader = new BufferedReader(new FileReader(tempCsvFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String idHolded = fields[1];

                if (!id.equals(idHolded)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Employee> getAllFileDataIntoList(){

        List<Employee> employeeList = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String type = fields[0];
                String id = fields[1];
                String firstName = fields[2];
                String lastName = fields[3];
                String Date = fields[4];
                String number = fields[5];

                if(type.equals("Concepteur")){
                    employeeList.add(new Concepteur(Integer.parseInt(id),firstName,lastName,Date,Integer.parseInt(number)));
                }else{
                    employeeList.add(new Analyste(Integer.parseInt(id),firstName,lastName,Date,Integer.parseInt(number)));
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return employeeList;
    }
}

