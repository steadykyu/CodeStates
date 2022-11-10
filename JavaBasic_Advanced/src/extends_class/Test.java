package extends_class;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
    }
}

class Human {


}

class Student extends Human { // Human 클래스로부터 상속
    Student() {

        System.out.println("학생 클래스 생성자");
    }
}

