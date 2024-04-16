package app.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Entity.Employee;
import app.Entity.ExperienceEmployee;
import app.Entity.FresherEmployee;
import app.Entity.InternEmployee;
import app.Model.EmployeeDB;

public class Controller {
    private List<Employee> eps = new ArrayList<>();

    public void addEmployee(Employee emp) {
        eps.add(emp);
        System.out.println("emp added successfully!");
    }

    // Read
    public void displayEmployee() throws SQLException {
        List<ExperienceEmployee> ex = EmployeeDB.EmployeeN().GetExperienceEmployee();
        List<FresherEmployee> fe = EmployeeDB.EmployeeN().GetFresherEmployee();
        List<InternEmployee> dt = EmployeeDB.EmployeeN().GetInternEmployee();
        if(eps.isEmpty()) {
            System.out.println("No eps in the list.");
        } else {
            for(Employee emp : eps) {
                System.out.println("ID: " + emp.getID() + ", Name: " + emp.getFullName() + ", Birthday " + emp.getBirthDay());
            }
        }
    }

    // Update
    public void updateEmployee(String id, String newName, String newBirthday) {
        for(Employee emp : eps) {
            if(emp.getID() == id) {
                emp.setFullName(newName);
                emp.setBirthDay(newName);
                System.out.println("emp updated successfully!");
                return;
            }
        }
        System.out.println("emp not found with ID: " + id);
    }

    // Delete
    public void deleteEmployee(String id) {
        for(Employee emp : eps) {
            if(emp.getID() == id){
                eps.remove(emp);
            }
        System.out.println("emp deleted successfully!");
    }
}
}
