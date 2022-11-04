class Person {
    String name; // 유저 닉네임이라고 해보자.
    PersonInfo personalInfo;
    public Person(String name, String socialNumber, String address) {
        this.name = name;
        personalInfo = new PersonInfo(socialNumber, address);
        //이거론 왜 안돼지?
//        PersonInfo personalInfo = new PersonInfo(socialNumber, address);
//        int age = 15;
    }

    // 회원 가입 메서드
    void save(){
        // name과 personalInfo 를 이용하여 회원가입 로직 실행했다고 가정
        System.out.println("회원가입 완료");
        System.out.println("이름 : "+ name);
        System.out.println("주민번호 : "+ personalInfo.SocialNumber);
        System.out.println("주소 : "+ personalInfo.ADDRESS);
    }

    public class PersonInfo{
        private String name;

        // 주민번호
        private final String SocialNumber;
        private final String ADDRESS;

        private PersonInfo(String socialNumber, String address) {
            this.SocialNumber = socialNumber;
            this.ADDRESS = address;
        }

        public String getSocialNumber() {
            return SocialNumber;
        }

        public String getAddress() {
            return ADDRESS;
        }
    }

}
public class SignUp {
    public static void main(String[] args) {
        Person kyu = new Person("steadykyu", "950204-xxxxxx", "Seoul");
        kyu.save();
    }
}

