package graph.dfs;

import java.util.*;

/**
 * 줄다리기
 * 현수네 반 총 인원수는 7명입니다. 오늘은 운동회 날로 반대항 줄다리기 시합이 있습니다.
 * 현수네 반 총 인원인 7명이 모두 줄다리기에 출전합니다.
 * 선생님은 줄다리기를 하기 위해 7명을 일렬로 세우는데 서로 싫어하는 학생끼리 이웃하게 일
 * 렬로 세우면 경기력이 저하되어 정상적인 경기력이 나오지 않습니다.
 * 매개변수 nums에 현수네 반 학생의 서로 싫어하는 정보가 주어지면 서로 싫어하는 학생끼리
 * 이웃하지 않게 줄을 세우는 경우수를 알고싶습니다. 즉 정상적인 경기력으로 줄다리기를 하기
 * 위해 7명을 일렬로 세울 수 있는 모든 방법의 수를 구해 반환하는 프로그램을 작성하세요.
 */
public class TugOfWar {
    int answer;
    int[][] relation;
    int[] chk = new int[8];
    Deque<Integer> stack;
    public int solution(int[][] fight){
        answer = 0;
        stack = new ArrayDeque<>();
        relation = new int[8][8];
        for(int[] a : fight) {
            relation[a[0]][a[1]] = 1;
            relation[a[1]][a[0]] = 1;
        }
        dfs(0);
        return answer;
    }

    private void dfs(int lv) {
        if(lv == 7) {
            answer++;
        } else {
            for(int i = 1 ; i <= 7 ; i++) {
                if(!stack.isEmpty() && relation[stack.peek()][i] == 1)
                    continue;
                if(chk[i] == 0) {
                    chk[i] = 1;
                    stack.push(i);
                    dfs(lv + 1);
                    chk[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args){
        TugOfWar T = new TugOfWar();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

}
