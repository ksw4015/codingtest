package greedy;

import java.util.Arrays;
import java.util.HashMap;

public class BestTimeForSellStock {
    private static int solution(int[] prices) {
        int answer = 0;

        for(int i = 0 ; i < prices.length - 1 ; i++) {
            int sell = prices[i+1] - prices[i];
            if(sell > 0) {
                answer += sell;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
    }

}
