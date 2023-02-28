package thread;

public class ThreadExample6 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                try {
                    while (true) Thread.sleep(1000);
                }
                catch (Exception e) {}
                System.out.println("Woke Up!!!");
            }
        };

        System.out.println("thread1.getState() = " + thread1.getState()); // New

        thread1.start();

        System.out.println("thread1.getState() = " + thread1.getState());

        while (true) {
            if (thread1.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        thread1.interrupt(); // 예외를 출력하며 실행 대기 상태로 만든다.

        while (true) {
            if (thread1.getState() == Thread.State.RUNNABLE) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        while (true) {
            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
    }
}
