package app.MartService.customer;

public class Customer {
    private int id;
    private String name;
    // 핸드폰 가격은 백만원이다.

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
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

}
