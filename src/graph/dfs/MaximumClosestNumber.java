package graph.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 가장 가까운 큰 수
 *
 * 주어진 수 n 보다 큰 수 중 가장 작은 수를 반환
 */
public class MaximumClosestNumber {
    static int answer = Integer.MAX_VALUE;

    public void solution(int n){
        // n을 int 배열로 변환
        String num = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < num.length() ; i++) {
            list.add(Integer.valueOf(String.valueOf(num.charAt(i))));
        }
        dfs(list, new ArrayList<>(list), new StringBuilder(), 0, n);
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private void dfs(List<Integer> original, List<Integer> copy, StringBuilder result, int lv, int n) {
        if(lv == original.size()) {
            int res = Integer.parseInt(result.toString());
            if(n < res) {
                answer = Math.min(answer, res);
            }
            return;
        }
        for(Integer i : copy) {
            List<Integer> nextElements = new ArrayList<>(copy);
            nextElements.remove(i);
            dfs(original, nextElements, new StringBuilder(result).append(i), lv + 1, n);
        }
    }

    /**
     * 강의 풀이
     * @param n Target Number
     */
    List<Integer> nums;
    int answer2;
    int[] chk;
    boolean flag;

    public int solution2(int n) {
        String num = String.valueOf(n);
        answer2 = 0;
        flag = false;
        nums = new ArrayList<>();
        for(int i = 0 ; i < num.length() ; i++) {
            nums.add(Integer.valueOf(String.valueOf(num.charAt(i))));
        }
        // 리스트 오름차순 정렬
        nums.sort(Comparator.comparingInt(a -> a));
        // DFS 체크 배열 선언
        chk = new int[nums.size()];
        dfs2(0, 0, n);
        if(!flag)
            return -1;
        return answer2;
    }

    /**
     *
     * @param lv 탐색 깊이
     * @param number 만들어 지는 숫자
     */
    public void dfs2(int lv, int number, int n) {
        if(flag)
            return;
        if(lv == nums.size() && number > n) {
            answer2 = number;
            flag = true;
        } else {
            for(int i = 0 ; i < nums.size() ; i++) {
                if(chk[i] == 0) {
                    chk[i] = 1; // 다음 탐색에서 체크된 값은 Pass
                    dfs2(lv + 1, number*10 + nums.get(i), n);
                    chk[i] = 0; // 앞선 탐색 종료 후 체크해제
                }
            }
        }
    }

    public static void main(String[] args) {
        MaximumClosestNumber T = new MaximumClosestNumber();
        System.out.println(T.solution2(123));
        System.out.println(T.solution2(321));
        System.out.println(T.solution2(20573));
        System.out.println(T.solution2(27711));
        System.out.println(T.solution2(54312));
    }
}
