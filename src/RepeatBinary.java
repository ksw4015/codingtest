import java.util.Arrays;

/**
 * 프로그래머스
 * 이진 변환 반복하기
 */
public class RepeatBinary {
    static int zero = 0;

    private static int[] solution(String s) {
        int result = zeroCount(s);
        if(result == 1) {
            return new int[]{1, zero};
        }

        int[] answer = {0, 0};
        int cnt = 1;
        while (true) {
            cnt++;
            String bi = Integer.toBinaryString(result);
            result = zeroCount(bi);
            if(result == 1) {
                answer[0] = cnt;
                answer[1] = zero;
                return answer;
            }
        }
    }

    private static int zeroCount(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                cnt++;
            }
        }
        zero += cnt;
        return s.length() - cnt;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("100000000010000000110")));
    }
}
