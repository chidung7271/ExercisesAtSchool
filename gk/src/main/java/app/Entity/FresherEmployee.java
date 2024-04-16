package app.Entity;

public class FresherEmployee extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public FresherEmployee(String ID, String fullName, String birthDay, String phone, String email, String employeeType, String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
    }

    // Add other methods specific to FresherEmployee
}

