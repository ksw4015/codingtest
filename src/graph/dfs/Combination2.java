package graph.dfs;

import java.util.Scanner;

/**
 * 조합구하기
 * 배열 이용
 */
public class Combination2 {
    // 조합기록
    static int[] result;
    static int n;

    private static void dfs(int lv, int start) {
        if(lv == result.length) {
            for(int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = start ; i <= n ; i++) {
                result[lv] = i;
                dfs(lv + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        result = new int[m];
        dfs(0, 1);
        System.out.println(result[0] + " " + result[1]);
    }

}
