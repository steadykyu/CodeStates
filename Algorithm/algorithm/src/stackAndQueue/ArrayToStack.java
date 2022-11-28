package stackAndQueue;

import java.util.Arrays;

public class ArrayToStack {
    private Object[] array = new Object[]{};

    public void push(Integer data) {
        array = Arrays.copyOfRange(array, 0, array.length+1);
        array[array.length-1] = data;
    }

    public Integer pop() {
        Object res = array[array.length-1];
        array = Arrays.copyOfRange(array, 0, array.length-1);
        return (int)res;
    }

    public int size() {
        return array.length;
    }

    public Integer peek() {
        if(array.length==0) {
            return null;
        }else {
            return (int)(array[array.length-1]);
        }
    }

    public String show() {
        return Arrays.toString(array);
    }
    public void clear() { array = new Object[]{}; }
}
class Main{
    public static void main(String[] args) {
        ArrayToStack ats = new ArrayToStack();
        ats.push(1);
        ats.push(2);
        ats.push(3);

        ats.pop();
        System.out.println(ats.size());
        System.out.println(ats.show());
    }
}

// 배열을 썼을때의 단점
// 1. 배열은 모든 타입이 같아야하기 때문에, Stack을 만들려면 모든 타입에 대한 메서드를 만들어야한다.
// 2. 후입선출을 만족하기 위해, 여러 소스코드 작성이 필요하다.

// 나는 배열을 복사해서 풀었는데, 어떤 분은 index값을 증감하면서 푼 분도 있다.


