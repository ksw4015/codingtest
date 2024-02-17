import java.util.*;

/**
 * LeetCode 49번 문제
 * 그룹 애너그램
 * 애너그램인 단어들을 char정렬하면 모두 같은 값이된다.
 */
public class GroupAnagrams {

    /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> results = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.copyValueOf(chars);
            if(!results.containsKey(key))
                results.put(key, new ArrayList<>());
            results.get(key).add(s);
        }
        return new ArrayList<>(results.values());
    }

    public static void main(String[] args) {
        List<List<String>> anagrams = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(anagrams.toString());
    }
}
