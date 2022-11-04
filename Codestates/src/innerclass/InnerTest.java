class Outer2{
    int a = 100;

    //멤버 내부 클래스
    class Inner2{
        int a = 200;
        public void method1(){
            int a = 300;
            System.out.println("a = "+a);
            System.out.println("this.a = "+Inner2.this.a);
            System.out.println("this.a = "+this.a);
            System.out.println("Outer2.this.a = "+ Outer2.this.a);
            //위치가 명확하지 않으면 위치를 써놓고 this를 쓰는것이 좋음
        }
    }
}

public class InnerTest {
    public static void main (String[] args){
        Outer2.Inner2 oi = new Outer2().new Inner2();
        oi.method1();
    }
}