package bst;

import java.util.Arrays;

/**
 * 두 수의 합이 타겟 넘버인 경우의 인덱스
 */
public class TwoSumIsSorted {
    /*
        투포인터
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        // 두개의 포인터를 교차시키면서 찾음
        while (left != right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        return null;
    }

    /*
        이진 검색
     */
    public int[] twoSum2(int[] numbers, int target) {
        for(int i = 0 ; i < numbers.length ; i++) {
            // 자신을 제외한 이후 Index로 길이조절
            int i2 = Arrays.binarySearch(numbers, i+1, numbers.length, target - numbers[i]);
            if(i2 >= 0) {
                return new int[]{i+1, i2+1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumIsSorted T = new TwoSumIsSorted();
        for(int i : T.twoSum2(new int[]{2,3,4}, 6)) {
            System.out.println(i + " ");
        }
        for(int i : T.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)) {
            System.out.println(i + " ");
        }
    }
}
