public class ShoppingMall {
    public static void main(String[] args) {
        Seller seller = new Seller();
        seller.setIphonePrice(1000000);
        seller.setGalaxyPrice(1000000);
        // 판매자는 백만원에 아이폰 가격을 설정했다.

        double IphoneSellPrice = seller.getIphonePrice() * 0.2;
        double GalaxySellingPrice = seller.getGalaxyPrice() * 0.4;

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
