import java.util.*;

/**
 * LeetCode 819번 문제
 */

public class MostCommonWord {

    /*
    case1:
        Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
        Output: "ball"
    case2:
        Input: paragraph = "a.", banned = []
        Output: "a"
     */

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> ban = Arrays.asList(banned);
        // \W+ : 연속된 문자가 아닌 문자열
        String[] paras = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String para : paras) {
            if(!ban.contains(para)) {
                map.put(para, map.getOrDefault(para, 0) + 1);
            }
        }
        // Collectios이 아닌 stream Api를 이용할 경우 2ms 빠름
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(s, banned));
    }
}
