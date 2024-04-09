package hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 서로 다른 빈도수 만들기
 * 모든 문자가 서로 빈도수가 달라야 함
 * 1이 여러개인경우 1 하나만 남기고 0으로 만들기
 */
public class DifferentFrequency {
    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        /*
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        for(int i : list) {
            while (true) {
                if(!set.contains(i)) {
                    set.add(i);
                    break;
                } else {
                    i--;
                    answer++;
                    if(i == 0)
                        break;
                }
            }
        }
        */
        for(char key : map.keySet()){
            while(set.contains(map.get(key))){
                answer++;
                map.put(key, map.get(key) - 1);
            }
            if(map.get(key) == 0)
                continue;
            set.add(map.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        DifferentFrequency T = new DifferentFrequency();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
