package app.Entity;
public class ExperienceEmployee extends Employee {
    private int expInYear;
    private String proSkill;

    public ExperienceEmployee(String ID, String fullName, String birthDay, String phone, String email, String employeeType, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Experience in Years: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }

    // Add other methods specific to ExperienceEmployee
}