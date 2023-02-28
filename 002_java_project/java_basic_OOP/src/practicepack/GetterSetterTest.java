package practicepack;

public class GetterSetterTest {
    public static void main(String[] args) {
        Worker w = new Worker();
        w.setName("김코딩");
        w.setAge(30);
        w.setId(5);

        String name = w.getName();
        System.out.println("근로자의 이름은 " + name);
        int age = w.getAge();
        System.out.println("근로자의 나이는 " + age);
        int id = w.getId();
        System.out.println("근로자의 ID는 " + id);


        name = "김규하";   // 해당 주소값에 "김코딩" 아니라 "김규하"가 들어간다.
        System.out.println("근로자의 이름은 " + name); // 김코딩
        System.out.println(w.getName()); //김규하
        // Getter로 값만 꺼내왔기 때문에, Worker 클래스의 name("김코딩") 은 잘 보호되고 고 있다.
    }
}

class Worker {
    private String name; // 변수의 은닉화. 외부로부터 접근 불가
    private int age;
    private int id;

    public String getName() { // 멤버변수의 값
        return name;
    }

    public void setName(String name) { // 멤버변수의 값 변경
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 1) return;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
