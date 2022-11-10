public class Main {
    public static void main(String[] args) {
        // 판매자는 아이폰과 갤럭시 폰의 가격을 100만원으로 설정했다.
        Seller seller = new Seller();
        seller.setIphonePrice(1000000);
        seller.setGalaxyPrice(1000000);

//        double IphoneSellPrice = seller.getIphonePrice() * 0.9;
//        double GalaxySellPrice = seller.getGalaxyPrice() * 0.8;

        Event event = new Event();
        double IphoneSellPrice = event.IphonePointEvent(seller); // 5000원 할인
        double GalaxySellPrice = event.GalaxyPointEvent(seller); // 10000원 추가할인
        
        System.out.println("아이폰 판매 가격은 : "+ IphoneSellPrice); // 895000.0
        System.out.println("갤럭시 판매 가격은 : "+ GalaxySellPrice); // 790000.0
        }
}
