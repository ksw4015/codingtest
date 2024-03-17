package graph.dfs;

import java.util.Scanner;

public class ExChangeCoin {
    static int extra = 15;
    static int result = 500;
    static int[] coins;

    private static void dfs(int sum, int cnt) {
        if(sum > extra)
            return;
        if(cnt > result)
            return;
        if(sum == extra) {
            result = Math.min(result, cnt);
            return;
        }
        for(int i = coins.length - 1 ; i >= 0 ; i--) {
            dfs(sum + coins[i], cnt + 1);
        }
//        for (int coin : coins) {
//            dfs(sum + coin, cnt + 1);
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        coins = new int[n];
        for(int i = 0 ; i < n ; i++) {
            coins[i] = Integer.valueOf(s[i]);
        }
        extra = Integer.valueOf(sc.nextLine());
        dfs(0, 0);
        System.out.println(result);
    }
}
