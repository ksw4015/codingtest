package twopointer;

public class TwoPointerBasic {
    /*
        연속된 수열의 합이 주어진 값이 되는 경우를 구하는 문제
        Input: [1, 2, 3, 2, 5] / M = 5
        2,3 / 3,2 / 5 총 3가지 경우
     */

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 5};
        int end = 0;
        int sum = 0;
        int count = 0;
        for (int i : input) {
            while (sum < 5 && end < input.length) {
                sum += input[end];
                end++;
            }
            if (sum == 5) {
                count++;
            }
            sum -= i;
        }

        System.out.println("" + count);
    }

}
