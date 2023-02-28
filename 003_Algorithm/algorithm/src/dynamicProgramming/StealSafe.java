package dynamicProgramming;

public class StealSafe {

    public long ocean(int target, int[] type) {
//     훔치고 싶은 target 금액과 금고에 있는 돈의 종류 type 을 입력받아,
//     조지가 target 을 훔칠 수 있는 방법의 수를 리턴하세요.

        // target 크기만큼 dp를 생성한다.
        // dp[j] 는 j원을 만드는데 필요한 경우의 수를 의미한다.
        long[] dp = new long[target+1];

        // 모든 x원 type으로 x금액을 만드는 경우
        // ex) 10원로 10원 만드는 경우, 20원로 20원 만드는 경우
        dp[0] = 1;

        for(int i=0; i < type.length; i++){
            for(int j = type[i]; j <= target; j++){
                dp[j] = dp[j] + dp[j - type[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        StealSafe ss = new StealSafe();
        long output = ss.ocean(50, new int[]{10, 20, 50});
        System.out.println(output); // 4
    }
}
