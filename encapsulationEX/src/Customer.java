public class Customer {
    int money;

    public Customer(int money) {
        this.money = money;
    }

    void buy(double price){
        if(money < price) System.out.println("구매하지 못했습니다.");
        else {
            money -= price;
            System.out.println("구매했습니다.");
        }
    }
}
