package app;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;

public class PhoneInfo {
    private int price;
    private String kind;


    public PhoneInfo(int price, String kind) {
        this.price = price;
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice(int discountRate){
        return getPrice() - getPrice() * discountRate / 100;
    }

}
