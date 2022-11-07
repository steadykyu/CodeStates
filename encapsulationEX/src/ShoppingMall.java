public class ShoppingMall {
    public static void main(String[] args) {
        Seller seller = new Seller();
        seller.setIphonePrice(1000000);
        seller.setGalaxyPrice(1000000);
        // 판매자는 백만원에 아이폰 가격을 설정했다.

        double IphoneSellPrice = eventIphonePrice(seller);
        double GalaxySellingPrice = seller.getGalaxyPrice() * 0.8;

        Customer moneyCustomer = new Customer("현금");
        Customer cardCustomer = new Customer("카드");
        Customer pointCustomer = new Customer("포인트");

    }
    public double eventIphonePrice(Seller seller){
        return seller.getIphonePrice() * 0.9 * 0.05;
    }
}

//        // 고객 4명
//        Customer richCustomer = new Customer(2000000);
//        Customer normalCustomer1 = new Customer(700000);
//        Customer normalCustomer2 = new Customer(600000);
//        Customer normalCustomer3 = new Customer(500000);
//
//        richCustomer.buy(iphonePrice);
//        normalCustomer1.buy(iphonePrice);
//        normalCustomer2.buy(iphonePrice);
//        normalCustomer3.buy(iphonePrice);
