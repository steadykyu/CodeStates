package staticExample;

public class StaticFieldTest {
    public static void main(String[] args) {
        StaticField staticField1 = new StaticField();
        StaticField staticField2 = new StaticField();

        staticField1.num1 = 100;
        staticField2.num1 = 1000;

        System.out.println(staticField1.num1);
        System.out.println(staticField2.num1);

        StaticField.setNum2(150);
        StaticField.setNum2(1500);

        System.out.println(StaticField.getNum2());
        System.out.println(StaticField.getNum2());
    }
}

class StaticField{
    int num1 = 10;
    private static int num2;

    public static void setNum2(int num2) {
        StaticField.num2 = num2;
    }

    public static int getNum2() {
        return num2;
    }
}
