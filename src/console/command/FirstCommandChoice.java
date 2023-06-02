package console.command;

import console.MainConsole;
import data.DataWriter;
import entity.Analyste;
import entity.Concepteur;
import entity.Employee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstCommandChoice {

    private final DataWriter dataWriter = new DataWriter();

    public void choiceCommand(Scanner scanner, List<Employee> employeeList){
        System.out.println("A_Afficher la liste des salariés existants.");
        System.out.println("B_Ajouter un concepteur.");
        System.out.println("C_Ajouter un analyste.");
        System.out.println("D_Supprimer un salarié.");
        System.out.println("E_Afficher les salariés embauchés depuis une certaine date.");
        System.out.println("F_Afficher les concepteurs ayant une expérience de développement supérieure à un certain nombre d'années.");
        System.out.println("Q_Exit");
        String choice = scanner.nextLine();
        switch (choice){
            case "A":
                this.listAllEmployees(employeeList);
                break;
            case "B":
                this.addConcepter(employeeList,scanner);
                System.out.println("Added Successfully");
                break;
            case "C":
                this.addAnalyste(employeeList,scanner);
                System.out.println("Added Successfully");
                break;
            case "D":
                if(employeeList.size() == 0){
                    System.out.println("Il n'y a rien à supprimer");
                    break;
                }
                this.removeEmployee(employeeList,scanner);
                break;
            case "E":
                this.listEmployeesBeforeCertainDate(employeeList,scanner);
                break;
            case "F":
                this.listEmployeesWithSpecificExperience(employeeList, scanner);
                break;
            case "Q":
                System.out.println("Shutdown...");
                MainConsole.isUp = false;
                break;
            default:
                System.out.println("veuillez choisir un choix disponible");
                break;
        }
}
    private void listAllEmployees(List<Employee> employeeList){
         employeeList.stream().forEach(employee -> System.out.println(employee.toString()));
    }

    private void addConcepter(List<Employee> employeeList,Scanner scanner){
        String firstName;
        String lastName;
        String date;
        Integer yearofExperience;
        System.out.println("Écrire le prénom du concepteur");
        firstName = scanner.nextLine();
        System.out.println("Écrire le nom de famille du concepteur");
        lastName = scanner.nextLine();
        System.out.println("Écrivez la date d'embauche YYYY/MM/DD si la date est aujourd'hui, laissez-la vide, nous ajouterons automatiquement la date d'aujourd'hui");
        date = scanner.nextLine();
        System.out.println("Écrire le numero d'experience de cette concepteur");
        yearofExperience = Integer.parseInt(scanner.nextLine());
        Concepteur concepteur = new Concepteur(
                employeeList.size() +1,
                firstName,
                lastName,
                date,
                yearofExperience);
        employeeList.add(concepteur);
        dataWriter.addObjectIntoThefile(concepteur);
    }
    private void addAnalyste(List<Employee> employeeList,Scanner scanner){
        String firstName;
        String lastName;
        String date;
        Integer numberOfClients;
        System.out.println("Écrire le prénom du analyste");
        firstName = scanner.nextLine();
        System.out.println("Écrire le nom de famille du analyste");
        lastName = scanner.nextLine();
        System.out.println("Écrivez la date d'embauche YYYY/MM/DD si la date est aujourd'hui, laissez-la vide, nous ajouterons automatiquement la date d'aujourd'hui");
        date = scanner.nextLine();
        System.out.println("Écrire le numero des client avez ce analyste");
        numberOfClients = Integer.parseInt(scanner.nextLine());

        Analyste analyste = new Analyste(
                employeeList.size() +1,
                firstName,
                lastName,
                date,
                numberOfClients);

        employeeList.add(analyste);
        dataWriter.addObjectIntoThefile(analyste);
    }

    public void removeEmployee(List<Employee> employeeList, Scanner scanner) {
        this.listAllEmployees(employeeList);
        System.out.println("Quel employé souhaitez-vous supprimer, insérez son identifiant");
        int id = scanner.nextInt();
        Optional<Employee> employee = employeeList.stream().filter(
                emp -> emp.getId() == id
        ).findFirst();
        System.out.println(employee.get().toString());
        if(employee.isPresent()){
            employeeList.remove(employee.get());
            dataWriter.removeTargetedObjectFromTheFile(String.valueOf(employee.get().getId()));
            System.out.println("Employee removed");
        }else {
            System.out.println("Insert a valid id");
        }
    }

    private void listEmployeesBeforeCertainDate(List<Employee> employeeList,Scanner scanner){
        System.out.println("Insérez une date dans ce format YYYY/MM/DD");
        List<Analyste> analystesList = employeeList.stream().filter(
                        emp -> emp instanceof Analyste)
                .map(emp -> (Analyste) emp)
                .collect(Collectors.toList()) ;

        LocalDate targetDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        employeeList.stream()
                .filter(emp -> LocalDate.parse(emp.getDateEmbauche(), DateTimeFormatter.ofPattern("yyyy/MM/dd")).isBefore(targetDate))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

   public void listEmployeesWithSpecificExperience(List<Employee> employeeList,Scanner scanner){
        System.out.println("Veuillez insérer le niveau d'expérience que l'employé devrait avoir");
        List<Concepteur> concepteursList = employeeList.stream()
                        .filter(emp -> emp instanceof Concepteur)
                        .map(emp -> (Concepteur) emp)
                        .collect(Collectors.toList());
                int year = scanner.nextInt();
                concepteursList.stream()
                        .filter(emp -> emp.getYearsOfExperience() > year)
                        .forEach(System.out::println);
    }
}
