package slidingwindow;

import java.util.Scanner;

/**
 * 연속 부분 수열
 */
public class SubPermutation {

    private static int solution(int[] numbers, int target) {
        int answer = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < numbers.length) {
            sum += numbers[right];
            if(sum < target) {
                right++;
            } else if(sum > target) {
                sum -= numbers[left];
                left++;
            }

            if(sum == target) {
                answer++;
                sum -= numbers[left];
                left++;
                right++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] input1 = in.nextLine().split(" ");
        String[] input2 = in.nextLine().split(" ");
        int n = Integer.valueOf(input1[0]);
        int target = Integer.valueOf(input1[1]);
        int[] numbers = new int[n];
        for(int i = 0 ; i < n ; i++) {
            numbers[i] = Integer.valueOf(input2[i]);
        }
        System.out.println(solution(numbers, target));
    }
}
