package twopointer;

import java.util.Scanner;

public class NSum {

    private static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int left = 1;
        for(int i = 1 ; i < n ; i++) {
            sum += i;
            while (n < sum) {
                sum -= left;
                left++;
            }
            if(sum == n) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
