public class Event {
    //카드할인
    public double IphoneCardEvent(Seller seller){
//        double IphoneSellPrice = seller.getIphonePrice() * 0.9; 캡슐화 x시
        double IphoneSellPrice = seller.getIphonePrice();
        double EventPrice = IphoneSellPrice * 0.95;
        return EventPrice;
    }
    //카드할인
    public double GalaxyCardEvent(Seller seller){
        //double GalaxySellPrice = seller.getGalaxyPrice()*0.8; 캡슐화x시
        double GalaxySellPrice = seller.getGalaxyPrice();
        double EventPrice = GalaxySellPrice * 0.95;
        return EventPrice;
    }

    public double IphonePointEvent(Seller seller){
            //double IphoneSellPrice = seller.getIphonePrice()*0.9; 캡슐화x시
            double IphoneSellPrice = seller.getIphonePrice();
            double EventPrice = IphoneSellPrice - 5000;
            return EventPrice;
            }

    public double GalaxyPointEvent(Seller seller){
            //double IphoneSellPrice = seller.getIphonePrice()*0.8; 캡슐화x시
            double GalaxySellPrice= seller.getGalaxyPrice();
            double EventPrice = GalaxySellPrice - 10000;
            return EventPrice;
            }
}
