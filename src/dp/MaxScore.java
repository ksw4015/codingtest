package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxScore {
    private static int solution(List<Problem> list, int limit) {
        int[] dy = new int[limit+1];
        for(Problem p : list) {
            for(int i = limit ; i >= p.time ; i--) {
                dy[i] = Math.max(dy[i], dy[i-p.time]+p.score);
            }
        }

        return dy[limit];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        List<Problem> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem(s, t));
        }
        System.out.println(solution(list, l));
    }

    private static class Problem {
        int score;
        int time;
        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
