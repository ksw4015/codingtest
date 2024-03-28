package simulation;

import java.util.Arrays;

/**
 * 구현 & 시뮬레이션
 * 청소 문제
 *
 * 행렬이 주어지고 (1 or 0으로 이루어짐)
 * 로봇청소기는 좌상단에서 시작 (0,0)
 *
 * 행렬 끝에 다다르거나 장애물(1)을 만나면 90도로 회전
 *
 * 이동과 회전에 1초 씩 소모
 */
public class RobotCleaner {
    /**
     *
     * @param board 청소 맵
     * @param k 로봇청소기가 움직일 수 있는 시간(초)
     * @return k초 후 로봇청소기 좌표
     */
    public int[] solution(int[][] board, int k){
        int[] answer = new int[]{0, 0};
        // 90도씩 회전 방향 동,남,서,북
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int dir = 0;
        int sec = 0;
        while (sec < k) {
            int y = answer[0] + dirY[dir];
            int x = answer[1] + dirX[dir];
            if(y < board.length && y >= 0 &&
                x < board[0].length && x >= 0 &&
                board[y][x] == 0) {
                answer[0] = y;
                answer[1] = x;
            } else {
                dir++;
                if(dir == 4)
                    dir = 0;
            }
            sec++;
        }
        return answer;
    }



    public static void main(String[] args) {
        RobotCleaner T = new RobotCleaner();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
