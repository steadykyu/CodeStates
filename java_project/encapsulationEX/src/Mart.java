public class Mart {
    private Iphone iphone;
    private GalaxyPhone galaxyPhone;

    public Mart(Iphone iphone, GalaxyPhone galaxyPhone) {
        this.iphone = iphone;
        this.galaxyPhone = galaxyPhone;
    }

    public void start(){
        System.out.println("마트가 시작됩니다.");

        Iphone iphone = new Iphone(1000000);
        GalaxyPhone galaxyPhone = new GalaxyPhone(1000000);


        double iphonePrice = iphone.getPrice();
        double galaxyPrice = galaxyPhone.getPrice();

        System.out.println("할인 적용중입니다.");
        // 아이폰이면 10프로 할인, 갤럭시면 20프로 할인 이라고 합시다.
        iphonePrice = iphone.getPrice()*0.9;
        galaxyPrice = galaxyPhone.getPrice()*0.8;

//        iphonePrice = iphone.getDiscountPrice();
//        galaxyPrice = galaxyPhone.getDiscountPrice();

        System.out.println("아이폰 가격은 : " + iphonePrice);
        System.out.println("갤럭시폰 가격은 : "+ galaxyPrice);
    }
}
