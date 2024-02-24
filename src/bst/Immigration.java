package bst;

import java.util.Arrays;

/**
 * 프로그래머스 고득점 KIt
 * 입국심사 (이진탐색) 문제
 */
public class Immigration {

    /*
        1. 입국심사대는 2곳이며 times 각각 입국심사 소요시간이 주어진다.
        2. n은 입국심사를 받아야될 사람의 수 이다
     */
    public long solution(int n, int[] times) {
        long answer = 0;
        // 1 ~ 입국심사 가장 오래걸리는 심사관의 소요시간 * n 이 초기 left ~ right
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;  // times내에서 가장 큰 값
        long mid = right;  // mid는 right로 초기화
        while (left <= right) {
            long calc = 0;
            for(long time : times)
                calc += (mid / time);  // mid을 각 심사관의 소요시간으로 나눠서 각각 몇명씩 걸리는지를 다 더함
            if(calc >= n) { // 합한 값이 총 심사를 기다리는 인원수 보다 크면 mid값을 -1
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;  // 합한 값이 인원수 보다
            }
            mid = left + (right - left) / 2;  // 중앙값 다시 계산
        }

        return answer;
    }

    public static void main(String[] args) {
        Immigration T = new Immigration();
        System.out.println(T.solution(2, new int[]{2, 4}));
    }

}
