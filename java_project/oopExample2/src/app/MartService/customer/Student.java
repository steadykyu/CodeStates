package app.MartService.customer;

public class Student extends Customer{
    private String schoolName;

    public Student(int id, String name, String customerType, String schoolName) {
        super(id, name, customerType);
        this.schoolName = schoolName;
    }
    public String getSchoolName() {
        return schoolName;
    }
}
