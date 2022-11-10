package Constructor;

public class ConstructorExample {
    public static void main(String[] args) {
        Constructor constructor1 = new Constructor();
        Constructor constructor2 = new Constructor("Hello world");
        Constructor constructor3 = new Constructor(5, 10);
    }
}

class Constructor{
    public Constructor() {
    }

    Constructor(String str){
        System.out.println("2번 생성자");
    }
    Constructor(int a, int b){
        System.out.println("3번 생성자");
    }
}



