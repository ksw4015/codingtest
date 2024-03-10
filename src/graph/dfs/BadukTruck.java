package graph.dfs;

import java.util.Scanner;

/**
 * DFS 강의
 * 바둑이 태우기
 * 가장 무겁게 태우기
 */
public class BadukTruck {
    int result = 0;
    int max = 0;
    private void dfs (int sum, int index, int[] baduks) {
        System.out.println(sum);
        if(sum > max)
            return;
        if(index == baduks.length) {
            result = Math.max(sum, result);
            return;
        }
        dfs(sum + baduks[index], index+1 , baduks);
        dfs(sum, index + 1, baduks);
    }

    public static void main(String[] args) {
        BadukTruck T = new BadukTruck();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        T.max = Integer.valueOf(s[0]);
        int n = Integer.valueOf(s[1]);
        int[] input = new int[n];
        sc = new Scanner(System.in);
        for(int i = 0 ; i < n ; i++) {
            input[i] = sc.nextInt();
        }
        T.dfs(0, 0, input);
        System.out.println(T.result);
    }
}
