package thread;

public class ThreadJoinExample {
        public static void main(String[] args) {
            SumThread sumThread = new SumThread();

            sumThread.setTo(10);

            sumThread.start();

            // 메인 스레드가 sumThread의 작업이 끝날 때까지 기다립니다.
            try { sumThread.join(); } catch (Exception e) {}

            System.out.println(String.format("1부터 %d까지의 합 : %d", sumThread.getTo(), sumThread.getSum()));
        }
    }

    class SumThread extends Thread {
        private long sum;
        private int to;

        public long getSum() {
            return sum;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }
        // 누적값을 구해주는 쓰레드가 있다.
        public void run() {
            for (int i = 1; i <= to; i++) {
                sum += i;
            }
        }
}
