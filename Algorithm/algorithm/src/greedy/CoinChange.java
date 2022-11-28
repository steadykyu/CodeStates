package greedy;

public class CoinChange {
    public int partTimeJob(int k) {
        // 조건 1 : 각 동전들은 서로 배수 관계에 있다.(1 5 10 50 100)
        // 조건 2 : 동전 개수를 최소로 하여 k 거스름돈을 만든다.

        // 동전 배열
        int[] coins = new int[]{1,5,10, 50 ,100,500};
        int res=0;
        int j=coins.length-1;
        while(k!=0){
            // 현재 금액의 동전 금액만큼 나누어 최대 동전의 개수를 구한다.
            res += k / coins[j];
//            System.out.println(coins[j]+ "의 개수 : " + res);
            //  남은 나머지를 구한다.
            k = k % coins[j];
            j = j-1; // 더 작은 동전으로 바꾸어준다.
        }

        return res;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.partTimeJob(4972));
    }
}
