package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준(1012번) 유기농 배추 - 실버2
 */
public class OrganicCabbage {

    /*
        첫줄 = 테스트 케이스 개수
        두번째 줄 = 테스트 케이스의 M x N 크기 및 배추의 총 개수
        세번째 줄 ~ = 테스트 케이스 밭의 양배추 좌표들
     */
    public void organicCabbage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스 개수
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int cabbageNumber = Integer.parseInt(st.nextToken()); // 양배추 개수
            int[][] field = new int[n][m];
            for(int j = 0 ; j < cabbageNumber ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            int count = 0;
            for(int y = 0 ; y < field.length ; y++) {
                for(int x = 0 ; x < field[y].length ; x++) {
                    if(field[y][x] == 1) {
                        dfs(x, y, field);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private void dfs(int x, int y, int[][] field) {
        if(x < 0 || x >= field[0].length || y < 0 || y >= field.length || field[y][x] == 0)
            return;
        field[y][x] = 0;
        dfs(x+1, y, field);
        dfs(x-1, y, field);
        dfs(x, y+1, field);
        dfs(x, y-1, field);
    }

}
