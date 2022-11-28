package Math;

public class Blackjack_combi {

    public int boringBlackjack(int[] cards) {
        int result = 0;
        // 카드 조회하기 - 조합 - for문 방식으로
        // 1 2 3 4
        for(int i=0; i < cards.length; i++){
            for(int j=i+1; j < cards.length; j++){
                for(int k=j+1; k < cards.length; k++){
                    // 주어진 수들로 새로운 숫자 만들기
                    int newNum = cards[i] + cards[j] + cards[k];
                    if(isPrime(newNum)) result++;
                }
            }
        }
        return result;
    }

    public boolean isPrime(int num){
        int sqrtNum = (int)Math.floor(Math.sqrt(num));
        for(int i=2; i <= sqrtNum; i++){
            // 제곱근까지 값이 나누어 진다면, 소수가 아니다.
            if(num % i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Blackjack_combi bj = new Blackjack_combi();
        System.out.println(bj.boringBlackjack(new int[]{1, 2, 3, 4}));

        System.out.println(bj.isPrime(7));
    }
}
