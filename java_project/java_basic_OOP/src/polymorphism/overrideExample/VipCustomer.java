package polymorphism.overrideExample;

public class VipCustomer extends Customer {
    private String VipId = "1324";
    void calPrice(){
        System.out.println("하위클래스에서 계산한 가격입니다.");
    }

    String getVipId(){
        return VipId;
    }
}
