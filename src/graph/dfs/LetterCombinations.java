package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    /*

     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;

        HashMap<Character, List<Character>> mapping = new HashMap<>();
        mapping.put('2', List.of('a','b','c'));
        mapping.put('3', List.of('d','e','f'));
        mapping.put('4', List.of('g','h','i'));
        mapping.put('5', List.of('j','k','l'));
        mapping.put('6', List.of('m','n','o'));
        mapping.put('7', List.of('p','q','r','s'));
        mapping.put('8', List.of('t','u','v'));
        mapping.put('9', List.of('w','x','y','z'));

        dfs(result, mapping, digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, Map<Character, List<Character>> map, String digits, int index, StringBuilder path) {
        // 정해진 숫자 길이와 path의 길이가 같아지면 result에 저장하고 리턴
        if(path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for(Character c : map.get(digits.charAt(index))) {
            // StringBuilder의 역할은 탐색 경로 저장용
            // 마지막 노드 전 까지의 path가 저장되어있으면 for 반복문내에서 dfs는 각 char당 한번씩만 실행 후 result에 저장
            dfs(result, map, digits, index + 1, new StringBuilder(path).append(c));
        }
    }

}
