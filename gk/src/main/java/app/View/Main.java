package app.View;

import java.util.Scanner;

import app.Controller.Controller;
import app.Entity.*;
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning=true;
        while(isRunning) {
            System.out.println("--- CRUD Operations ---");
            System.out.println("1. Add ");
            System.out.println("2. Display ");
            System.out.println("3. Update ");
            System.out.println("4. Delete ");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    
                                        
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter bd: ");
                    String bd = scanner.nextLine();
                    System.out.print("Choose type Employee ");
                    int data = scanner.nextInt();
                    switch(data){
                        case 1:
                        controller.addEmployee(new ExperienceEmployee(id, name, bd, null, null, null, 5, null));
                        
                        case 2:
                        controller.addEmployee(new FresherEmployee(id, name, bd, null, null, null, null, null, null));
                        case 3:
                        controller.addEmployee(new InternEmployee(id, name, bd, null, null, null, null, null, null));
                    break;
                }
                case 2:
                    controller.displayEmployee();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    String newBd = scanner.nextLine();
                    controller.updateEmployee(updateId, newName, newBd);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    controller.deleteEmployee(deleteId);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Program ended. Goodbye! 👋");
    }
}