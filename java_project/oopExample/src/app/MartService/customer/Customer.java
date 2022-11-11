package app.MartService.customer;

public class Customer {
    private int id;
    private String name;

    private int discountedPrice;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
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
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                '}';
    }
}
