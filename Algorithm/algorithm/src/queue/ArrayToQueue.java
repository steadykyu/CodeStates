package queue;

import java.util.Arrays;

public class ArrayToQueue {

    private Object[] array = new Object[]{};

    public void add(Integer data) {
        array = Arrays.copyOfRange(array, 0, array.length+1);
        array[array.length-1] = data;
    }

    public Integer poll() {
        Object res = array[0];
        array = Arrays.copyOfRange(array, 1, array.length);
        return (int)res;
    }

    public int size() {
        return array.length;
    }

    public Integer peek() {
        if(array.length==0) {
            return null;
        }else {
            return (int)(array[0]);
        }
    }

    public String show() {
        return Arrays.toString(array);
    }
    public void clear() { array = new Object[]{}; }

}

class Main{
    public static void main(String[] args) {
        ArrayToQueue atq = new ArrayToQueue();
        atq.add(1);
        atq.add(2);
        atq.add(3);

        System.out.println(atq.size()); //123
        System.out.println("poll() 출력한 값 = "+atq.poll());
        System.out.println(atq.size());
        System.out.println("peek() 출력한 값 = "+atq.peek());

        System.out.println(atq.show());


    }
}
