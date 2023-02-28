package dynamicProgramming;

import java.util.Arrays;

public class Coins {

    public static void main(String[] args) {
        int target = 10;
        int[] dp = new int[target+1]; // 0~10 index
        int[] coin = new int[]{1,3,5};

        Arrays.fill(dp, 100);
        dp[0] = 0;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }

    }
}
