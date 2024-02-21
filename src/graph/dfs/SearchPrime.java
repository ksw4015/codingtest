package graph.dfs;

import java.util.HashSet;

/**
 * 프로그래머스 완전탐색
 * 소수 찾기
 * dfs를 활용한 완전탐색
 */
public class SearchPrime {
    /*
        SubSet 만들기
        "17" -> 1, 7
        Expect : 1, 7, 17, 71
     */
    private void dfs(HashSet<Integer> results, boolean[] visited, String numbers, String s, int index) {
        // 굳이 없어도 되는 종료조건 인거같긴하다.
        if(index > numbers.length())
            return;
        for(int i = 0 ; i < numbers.length() ; i++) {  // i를 0부터 시작해서 완전히 탐색
            if(!visited[i]) {
                visited[i] = true;
                results.add(Integer.valueOf(s + numbers.charAt(i)));
                dfs(results, visited, numbers, s + numbers.charAt(i), index + 1);
                visited[i] = false; // 다음 index에서 반복할 재귀에서 현재 인덱스를 이용하기위해 false로 변경
            }
        }
    }

    public int solution(String numbers) {
        HashSet<Integer> results = new HashSet<>();  // 숫자의 중복을 피하기위한 Set선언
        boolean[] visited = new boolean[20];  // 방문 표시
        dfs(results, visited, numbers, "", 0);

        int answer = 0;
        System.out.println(results);
        for(Integer num : results) {
            if(num == 1 || num == 0)
                continue;
            if(isPrime(num))
                answer++;
        }
        return answer;
    }

    private boolean isPrime(int num) {
        for(int i = 2 ; i*i <= num ; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SearchPrime().solution("011"));
    }

}
