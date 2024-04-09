package math;

import java.util.Arrays;

/**
 * 프로그래머스 최소공배수
 *
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 */
public class Lcm {
    /**
     * a,b 의 최소공배수는
     * (a * b) / a,b의 최대공약수
     * @param arr
     * @return
     */
    public int solution(int[] arr) {
        int answer;
        Arrays.sort(arr);
        answer = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            int g = gcd(arr[i], answer);
            answer = (arr[i]*answer) / g;
        }
        return answer;
    }

    /**
     * 유클리드 호제법
     * 1. a를 b로 나눈다
     * 2. b를 1의 나머지로 나눈다
     * b가 0이 될때까지 1,2 반복
     * @param a 큰 수
     * @param b 작은 수
     * @return
     */
    private int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Lcm T = new Lcm();
        System.out.println(T.solution(new int[]{2,6,8,14}));
    }
}
