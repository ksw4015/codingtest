package array;

import java.util.Arrays;

public class ArrayPartition {
    /*
        [1,4,3,2]
        [6,2,6,5,1,2]
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int pairSum = 0;
        for(int i = 0 ; i < nums.length ; i+=2) {
            pairSum += Math.min(nums[i], nums[i+1]);
        }
        return pairSum;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + arrayPairSum(new int[]{1,4,3,2}));
        System.out.println("Result: " + arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

}
