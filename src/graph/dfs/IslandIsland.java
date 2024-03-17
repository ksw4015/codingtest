package graph.dfs;

import java.util.Scanner;

public class IslandIsland {
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    private static void dfs(int[][] island, int n, int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n || island[x][y] == 0) {
            return;
        }
        island[x][y] = 0;
        for(int i = 0 ; i < dx.length ; i++) {
            dfs(island, n, x+dx[i], y+dy[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] island = new int[n][n];
        sc = new Scanner(System.in);
        for(int i = 0 ; i < island.length ; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j = 0 ; j < island[0].length ; j++) {
                island[i][j] = Integer.valueOf(input[j]);
            }
        }

        int result = 0;
        for(int i = 0 ; i < island.length ; i++) {
            for(int j = 0 ; j < island[0].length ; j++) {
                if(island[i][j] == 1) {
                    dfs(island, n, i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
