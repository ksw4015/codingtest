package hashtable;

import java.util.HashSet;
import java.util.Set;

public class MaximumSequence {
    private static int solution(int[] nums){
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int  cnt = 1;
                int start = num;
                while (true) {
                    if(set.contains(++start)) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
