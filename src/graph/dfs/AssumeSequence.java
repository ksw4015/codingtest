package graph.dfs;

import java.util.Scanner;

public class AssumeSequence {

    static int[][] memo;
    // 조합의 값 저장배열
    static int[] b;
    // 정답 수열의 배열
    static int[] p;
    static int[] ch;

    static boolean flag = false;

    private static int combination(int n, int r) {
        if(memo[n][r] > 0)
            return memo[n][r];
        if(n == r || r == 0)
            return 1;
        return memo[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }

    private static void dfs(int lv, int n, int k, int sum) {
        if(flag)
            return;
        if(lv == n) {
            if(sum == k) {
                for(int i : p) {
                    System.out.println(i + " ");
                }
                flag = true;
            }
        } else {
            for(int i = 1 ; i <= n ; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[lv] = i;
                    dfs(lv+1, n, k, sum + (p[lv] * b[lv]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        memo = new int[35][35];
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for(int i = 0 ; i < n ; i++) {
            b[i] = combination(n-1, i);
        }
        dfs(0, n, k, 0);
    }
}
