package console;

import console.command.FirstCommandChoice;
import data.DataWriter;
import entity.Concepteur;
import entity.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsole {

    private Scanner scanner = new Scanner(System.in);
    public static boolean isUp = true;

    private final DataWriter dataWriter = new DataWriter();

    private List<Employee> employeeList = new ArrayList<>();

    private FirstCommandChoice firstCommandChoice = new FirstCommandChoice();

    public void runConsole()  {
        employeeList= dataWriter.getAllFileDataIntoList();
        while(this.isUp){
            firstCommandChoice.choiceCommand(scanner,employeeList);
        }
    }
}
