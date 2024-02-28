package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hash 강의
 * 모든 아나그램
 * (아나그램 : 순서와 관계없이 철자가 같은것)
 */
public class AllAnagram {
    /*
        IDE는 괜찮은데, 채점 사이트가 항상 에러남
     */
    private static int solution(String s, String ana) {
        int answer = 0;
        for(int i = 0 ; i <= s.length() - ana.length() ; i++) {
            char[] ch = s.substring(i, i+ana.length()).toCharArray();
            Arrays.sort(ch);
            if(ana.equals(String.valueOf(ch))) {
                answer++;
            }
        }

        return answer;
    }

    private static int solution2(String s, String ana) {
        HashMap<Character, Integer> aMap = new HashMap<>();
        for(char c : ana.toCharArray()) {
            aMap.put(c, aMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0 ; i < ana.length() ; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0 ) + 1);
        }
        int answer = 0;
        /*
            중요!
            Java equals 메서드로 Map 비교시
            Key,Value 쌍의 값이 모두 같으면 true반환
         */
        if(aMap.equals(sMap))
            answer++;

        for(int i = ana.length() ; i < s.length() ; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            char key = s.charAt(i - ana.length());
            sMap.put(key, sMap.get(key) - 1);
            if(sMap.get(key) <= 0)
                sMap.remove(key);
            if(aMap.equals(sMap))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ana = sc.nextLine();
        System.out.print(solution2(s, ana));
    }
}
