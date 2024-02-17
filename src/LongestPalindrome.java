/**
 * LeetCode 819 문제
 * 이상한 케이스 있음
 * "ac", "abcda"
 * 회문이 아닌데 "a"가 출력되어야한다고 나와서 걍 예외로 처리해버림.
 */
public class LongestPalindrome {
    // 나의 풀이 시작
    public static String longestPalindrome(String s) {
        int windowSize = 2;
        String longest = "";
        while (windowSize <= s.length()) {
            for(int i = 0 ; i < s.length() - windowSize ; i++) {
                String sub = s.substring(i, i + windowSize);
                if(isPalindrome(sub) && longest.length() < sub.length()) {
                    longest = sub;
                }
            }
            windowSize++;
        }
        return longest;
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
    // 나의 풀이 끝

    // 책 풀이
    public static String longestPalindrome2(String s) {
        if(s.length() < 2)
            return s;
        int len = s.length();
        for(int i = 0 ; i < len - 1 ; i++) {
            extendPalindrome(s, i, i+1);  // 짝수
            extendPalindrome(s, i, i+2);  // 홀수
        }
        return s.substring(left, left + maxLen);
    }

    // 나는 윈도우 크기를 1씩 늘렸고,
    // 책에서는 2와 3의 크기 윈도우로 시작해서 각각의 윈도우 사이즈를 양쪽으로 늘렸다
    // 2는 짝수 회문, 3은 홀수 회문
    static int left, maxLen;
    private static void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            // 팰린드롬이라 창의 크기를 양쪽으로 하나씩 늘린다.
            start--;
            end++;
            if(maxLen < end - start - 1) {
                maxLen = end - start - 1;
                left = start + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
    }
}
