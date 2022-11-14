package stream.optionalAdvanced;

import java.util.Optional;

public class MemberService {
    public Optional<Member> getMember(String id) {
        Optional<Insurance> insurance  = Optional.of(new Insurance("Samsung direct"));
        Optional<Car> car = Optional.of(new Car("XC-60", 60_000_000, insurance));
        return Optional.of(new Member("Kevin", "kevin1234", car));
    }
}