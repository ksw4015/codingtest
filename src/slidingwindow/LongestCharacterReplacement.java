package slidingwindow;

import java.util.*;

/**
 * LeetCode 424
 *
 * 코테 기초강의 문제와 비슷
 */
public class LongestCharacterReplacement {

    /*
        내 풀이 15ms
     */
    private static int solution(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }

        int answer = 0;
        for(Character replaceChar : set) {
            int left = 0, cnt = 0;
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) != replaceChar)
                    cnt++;
                while (k < cnt) {
                    if (s.charAt(left) != replaceChar)
                        cnt--;
                    left++;
                }
                answer = Math.max(answer, right - left + 1);
            }
        }
        return answer;
    }

    /*
      가장 많이 제출된 풀이 시간복잡도 O(n)
     */
    public int characterReplacement(String s, int k) {
        int l=0, max=0,res=0;
        int arr[] = new int[26];
        for(int r=0;r<s.length();r++){
            // Counting the number of each character in the string s
            arr[s.charAt(r)-'A']++;
            // Checking the character with max number of occurrence
            max = Math.max(max,arr[s.charAt(r)-'A']);
            // Now we check if our current window is valid or not
            if(r-l+1-max>k){
                //This window is invalid so we'll move left pointer towards right side
                //and also remove it's value from array
                arr[s.charAt(l)-'A']--;
                l++;
            }
            //max value from max and current window
            res = Math.max(res, r-l+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR", 2));
    }
}
