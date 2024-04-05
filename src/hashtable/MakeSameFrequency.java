package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSameFrequency {
    char[] keys = {'a', 'b', 'c', 'd', 'e'};
    public int[] solution(String s){
        int[] answer = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        for(int i = 0 ; i < answer.length ; i++) {
            if(map.containsKey(keys[i])) {
                answer[i] = max - map.get(keys[i]);
            } else {
                answer[i] = max;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        MakeSameFrequency T = new MakeSameFrequency();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}
