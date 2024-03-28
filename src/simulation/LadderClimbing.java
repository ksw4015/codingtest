package simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LadderClimbing {

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int i = 1 ; i <= n ; i++) {
            int position = i;
            for (int[] ints : ladder) {
                for (int lad : ints) {
                    if (position == lad) {
                        position += 1;
                        break;
                    } else if (position - 1 == lad) {
                        position -= 1;
                        break;
                    }
                }
            }
            answer[position-1] = (char) (65 + i-1);
        }
        return answer;
    }

    /*
        강의 풀이 (사다리를 동시에 탄다고 생각)
     */
    public char[] solution2(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int i = 0 ; i < n ; i++) {
            answer[i] = (char) (65+i);
        }
        for (int[] ints : ladder) {
            for (int lad : ints) {
                char tmp = answer[lad - 1];
                answer[lad - 1] = answer[lad];
                answer[lad] = tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        LadderClimbing T = new LadderClimbing();
        System.out.println(Arrays.toString(T.solution2(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution2(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution2(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution2(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

}
