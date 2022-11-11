package app.MartService.customer;

public class Student extends Customer{
    private String schoolName;

    public Student(int id, String name, String schoolName) {
        super(id, name);
        this.schoolName = schoolName;
    }
}
