package lambda;


import java.util.function.Function;

public class LambdaCore {
    public static void main(String[] args) {
        //    람다식을 매개변수와 Return으로 사용해보자.
        LambdaCore lc = new LambdaCore();
        Plus plusExample = lc.getLambda();
    }

    public Plus getLambda() {
         return (a, b) -> {return a+b;};
    }
}

interface Plus{
    int sum2(int a, int b);
}


