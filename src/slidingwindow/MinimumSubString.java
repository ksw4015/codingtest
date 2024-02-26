package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 76
 */
public class MinimumSubString {

    private String solution(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int missing = t.length();

        int left = 0, right = 0, start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        for(char c : s.toCharArray()) {
            right++;
            // 필요한 문자면 missing 1 감소
            if(need.containsKey(c) && need.get(c) > 0) {
                missing--;
            }
            // need맵에는 모든 문자가 발견될 때마다 1 감소
            need.put(c, need.getOrDefault(c, 0) - 1);

            // 필요한 문자를 다 찾은 경우
            if(missing == 0) {
                // 왼쪽 포인터를 1씩 증가시키면서 need에서 찾고
                // 찾은 값이 음수인경우 1씩 증가시켜준다.
                while (left < right && need.get(s.charAt(left)) < 0) {
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                missing++;
                left++;
            }
        }

        return s.substring(start, end);
    }

    public static void main(String[] args) {

    }
}
