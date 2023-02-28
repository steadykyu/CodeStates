package thread;

public class ThreadExample1_2 {
    public static void main(String[] args) {
        //
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 100; i++){
                    System.out.print("#");
                }
            }
        });
        thread3.start();

        for(int i = 0; i< 100; i++){
            System.out.print("@");
        }
    }
}
