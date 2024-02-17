package twopointer;

import java.util.Arrays;

public class TrappingRainWater {
    /*
        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
        Output : 6
     */
    public static int trappingRainWater(int[] height) {
        int rain = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        // Two Pointer Loop
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax) {
                rain += leftMax - height[left];
                left++;
            } else {
                rain += rightMax - height[right];
                right--;
            }
        }
        return rain;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + trappingRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
