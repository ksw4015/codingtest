package dp;

import java.util.*;

public class NapSackAlgorithm {

    static int result = Integer.MAX_VALUE;

    private static void dfs(List<Integer> coins, int k, int sum, int cnt) {
        if(sum > k)
            return;
        if(cnt > result)
            return;
        if(sum == k) {
            result = Math.min(result, cnt);
            return;
        }
        for(int i = 0 ; i < coins.size() ; i++) {
            dfs(coins, k, sum+coins.get(i), cnt + 1);
        }
    }

    private static int solution(List<Integer> coins, int k) {
        int[] dy = new int[k+1];
        for (Integer coin : coins) {
            for (int j = coin; j < dy.length; j++) {
                dy[j] = dy[j - coin] + 1;
            }
        }
        return dy[k+1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            coins.add(sc.nextInt());
        }
        int k = sc.nextInt();
        Collections.sort(coins);
        System.out.println(solution(coins, k));
    }
}
