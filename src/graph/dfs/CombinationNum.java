package graph.dfs;

import java.util.Scanner;

/**
 * 조합의 경우 수
 *
 * 아래의 공식을 재귀로 표현해보자
 * nCr = (n-1)C(r-1) + (n-1)C(r)
 *
 * n = r 거나 r = 0 이면 1
 */
public class CombinationNum {
    static int[][] memo;  // 메모이제이션 용 배열

    private static int dfs(int n, int r) {
        if(memo[n][r] > 0)
            return memo[n][r];
        if(n == r || r == 0) {
            return 1;
        }
        return memo[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        memo = new int[n+2][n+2];
        System.out.println(dfs(n, r));
    }
}
