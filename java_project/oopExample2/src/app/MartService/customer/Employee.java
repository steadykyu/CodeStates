package app.MartService.customer;

public class Employee extends Customer{
    private String martName;

    public Employee(int id, String name, String martName) {
        super(id, name);
        this.martName = martName;
    }


}
