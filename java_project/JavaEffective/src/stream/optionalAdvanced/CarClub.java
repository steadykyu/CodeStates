package stream.optionalAdvanced;

public class CarClub {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        String insuranceName =
                memberService
                        .getMember("kevin1234")
                        .flatMap(Member::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getCompanyName)
                        .get();

        System.out.println(insuranceName);
    }
}

// Optional 안쪽 객체를 요소로 사용하기 위해 위해 flatMap() 사용하고 있다.