package app.MartService.customer;

public class Employee extends Customer{

    private String martName;

    public Employee(int id, String name, String customerType, String martName) {
        super(id, name, customerType);
        this.martName = martName;
    }

    public String getMartName() {
        return martName;
    }
}
