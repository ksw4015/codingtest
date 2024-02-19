package graph.dfs;

/**
 * 백준 10773
 * 음료수 얼려먹기
 */
public class FreezingJuice {

    /*
        Input:
        [
            [0,0,1,1,0],
            [0,0,0,1,1],
            [1,1,1,1,1],
            [0,0,0,0,0]
        ]
     */
    public int solution(int[][] ice) {
        int count = 0;
        for(int i = 0 ; i < ice.length ; i++) {
            for(int j = 0 ; j < ice[i].length ; j++) {
                if(ice[i][j] == 0) {
                    dfs(j,i,ice);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, int[][] ice) {
        if(y < 0 || y >= ice.length || x < 0 || x >= ice[0].length || ice[y][x] == 1) {
            return;
        }
        ice[y][x] = 1;
        dfs(x+1, y, ice); // 동
        dfs(x-1, y, ice); // 서
        dfs(x, y+1, ice); // 남
        dfs(x, y-1, ice); // 북
    }

}
