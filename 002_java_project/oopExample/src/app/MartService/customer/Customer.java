package app.MartService.customer;

import app.PhoneInfo;

public class Customer implements Comparable<Customer>{
    private int id;
    private String name;
    private String customerType;

    public Customer(int id, String name, String customerType) {
        this.id = id;
        this.name = name;
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer c) {
        return name.compareTo(c.getName());
    }
}
