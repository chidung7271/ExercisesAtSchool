package app.Entity;

public class InternEmployee extends Employee {
    private String majors;
    private String semester;
    private String universityName;

    public InternEmployee(String ID, String fullName, String birthDay, String phone, String email, String employeeType, String majors, String semester, String universityName) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }

    // Add other methods specific to InternEmployee
}
