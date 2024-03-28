package greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 침몰하는 타이타닉
 * 그리디 문제 (강의 문제집)
 */
public class SinkingTitanic {
    public int solution(int[] nums, int m){
        int answer = 0;
        Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            deque.add(nums[i]);
        }

        while (!deque.isEmpty()) {
            int f = deque.pollFirst();
            int l = 0;
            if(!deque.isEmpty()) {
                l = deque.pollLast();
            }
            answer++;
            if(f + l > m) {
                deque.addLast(l);
            }
        }
        return answer;
    }

    /*
        Two-Pointer
     */
    public int solution2(int[] nums, int m) {
        int answer = 0;
        Arrays.sort(nums);
        int lp = 0;
        int rp = nums.length - 1;
        while (lp <= rp) {
            if(nums[lp]+nums[rp] <= m) {
                lp++;
            }
            rp--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        SinkingTitanic T = new SinkingTitanic();
        System.out.println(T.solution2(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution2(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution2(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
