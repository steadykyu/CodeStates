package thread;

public class ThreadExample1 {
    public static void main(String[] args) {
        Runnable task1 = new ThreadTask1();

        Thread thread1 = new Thread(task1);

        thread1.start();

        // 반복문 추가
        for (int i = 0; i < 100; i++) {
            System.out.print("@");
        }
    }
}

// Runnable 인터페이스를 구현하는 클래스
class ThreadTask1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
        }
    }
}
