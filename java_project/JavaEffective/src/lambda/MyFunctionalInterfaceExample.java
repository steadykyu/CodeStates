package lambda;

import java.util.function.IntBinaryOperator;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) throws Exception {
        IntBinaryOperator operato =  Math::max;
        System.out.println(operato.applyAsInt(1,3));


        MyFunctionalInterface example;
        example = (x, y) -> sum(x, y);
        System.out.println(example.accept(3,4));
    }

    public static int sum(int x, int y){
        return x + y;
    }



}
