package brute;

import java.util.Arrays;

public class BrownYellow {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i = sum ; i >= 2 ; i--) {
            if(sum % i == 0) {
                int m = sum / i;
                if((i-2) * (m-2) == yellow) {
                    answer[0] = i;
                    answer[1] = m;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BrownYellow T = new BrownYellow();
        System.out.println(Arrays.toString(T.solution(10, 2)));
        System.out.println(Arrays.toString(T.solution(8, 1)));
        System.out.println(Arrays.toString(T.solution(24, 24)));
    }
}
