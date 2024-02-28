package stack;

import java.util.*;

/**
 * 스택, 큐 강의
 * 카카오 인형뽑기
 */
public class ClawMachine {
    /**
     *
     * @param dolls 인형이 담긴 2차원 배열
     * @param moves 크레인이 움직인 방향
     * @return
     */
    private static int solution(int[][] dolls, int[] moves) {
        int answer = 0;
        List<Deque<Integer>> machine = new ArrayList<>();
        for(int i = 0 ; i < dolls.length ; i++) {
            machine.add(new ArrayDeque<>());
        }
        for(int i = dolls.length - 1 ; i >= 0 ; i--) {
            for(int j = 0 ; j < dolls[i].length ; j++) {
                if(dolls[i][j] != 0) {
                    machine.get(j).push(dolls[i][j]);
                }
            }
        }
        Deque<Integer> boxStack = new ArrayDeque<>();
        for(int i = 0 ; i < moves.length ; i++) {
            if(!machine.get(moves[i]-1).isEmpty()) {
                int popDoll = machine.get(moves[i]-1).pop();
                if(boxStack.isEmpty()) {
                    boxStack.push(popDoll);
                } else {
                    if(popDoll == boxStack.peek()) {
                        boxStack.pop();
                        answer += 2;
                    } else {
                        boxStack.push(popDoll);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[][] dolls = new int[][] {
//                {0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 3},
//                {0, 2, 5, 0, 1},
//                {4, 2, 4, 4, 2},
//                {3, 5, 1, 3, 1},
//        };
//        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] dolls = new int[n][n];
        for(int i = 0 ; i < dolls.length ; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j = 0 ; j < dolls[i].length ; j++) {
                dolls[i][j] = Integer.parseInt(input[j]);
            }
        }
        int k = Integer.parseInt(sc.nextLine());
        int[] moves = new int[k];
        String[] input2 = sc.nextLine().split(" ");
        for(int i = 0 ; i < k ; i++) {
            moves[i] = Integer.parseInt(input2[i]);
        }

        System.out.print(solution(dolls, moves));
    }
}
