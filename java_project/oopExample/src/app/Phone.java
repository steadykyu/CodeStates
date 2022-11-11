package app;

public class Phone{
    private int price;
    private String kind;

    public Phone(int price, String kind) {
        this.price = price;
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public int getPrice() {
        return price;
    }
}
