package thread;

public class ThreadExample4_currentThread {
        public static void main(String[] args) {

            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

            thread1.start();
            System.out.println(Thread.currentThread().getName());
        }

}
