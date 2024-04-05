package hashtable;

import java.util.HashMap;

public class FirstCharacter {
    private static int solution(String s) {
        int answer = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0 ; i < s.length() ; i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }
}
