package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2~5 kg의 화물들만 있음
 * 한번에 5kg까지만 이동 가능
 * 최소 회수를 구하라
 */
public class MovingCount {
    public int solution(int[] nums){
        int answer = 0;
        int two = 0;
        for(int i : nums) {
            if(i == 2) {
                two++;
            } else if(i == 3) {
                answer++;
                two--;
            } else {
                answer++;
            }
        }
        if(two > 0) {
            answer += two / 2;
        }
        return answer;
    }

    public int twoPointer(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if(nums[left] + nums[right] <= 5) {
                left++;
                right--;
                answer++;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        MovingCount T = new MovingCount();
        System.out.println(T.twoPointer(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.twoPointer(new int[]{2, 3, 4, 5}));
        System.out.println(T.twoPointer(new int[]{3, 3, 3, 3, 3}));
    }
}
