package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++) {  // 8
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i+1 ; j < nums.length - 1 ; j++) { // 9
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                for(int k = j+1 ; k < nums.length ; k++) { // 10
                    if(k > j+1 && nums[k] == nums[k-1])
                        continue;
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);
                        result.add(sum);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left, right, sum;
        for(int i = 0 ; i < nums.length-2 ; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 중복값 체크
                    while (left < right && nums[left] == nums[left+1]) // 뒤의 숫자와 비교후 같은 값이면 포인터 오른쪽으로 이동
                        left += 1;
                    while (left < right && nums[right] == nums[right-1]) // 앞의 숫자와 비교후 같은 값이면 포인터 왼쪽으로 이동
                        right -= 1;
                    left += 1;
                    right -= 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("" + threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }

}
