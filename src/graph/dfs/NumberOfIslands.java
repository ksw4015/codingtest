package graph.dfs;

public class NumberOfIslands {

    /*
        Input: grid = [
                         ["1","1","1","1","0"],
                         ["1","1","0","1","0"],
                         ["1","1","0","0","0"],
                         ["0","0","0","0","0"]
                      ]
     */

    private void dfs(int y, int x, char[][] grid) {
        // 노드가 '0'이거나 노드가 존재하지 않는 경우 함수(재귀)종료
        if(y < 0 || y >= grid.length || x < 0 || x >= grid[0].length || grid[y][x] == '0')
            return;
        // 한번만 탐색
        grid[y][x] = '0'; // 탐색하는 노드는 물로 변경 -> 현재 행렬에 재방문 하지않아도 되기 때문에
        dfs(y, x + 1, grid);  // 동
        dfs(y, x - 1, grid);  // 서
        dfs(y + 1, x, grid);  // 남
        dfs(y - 1, x, grid);  // 북
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int y = 0 ; y < grid.length ; y++) {
            for(int x = 0 ; x < grid[y].length ; x++) {
                // DFS를 재귀로 구현했기때문에 한번의 재귀가 모두 끝나면 count를 1 증가시킨다
                if(grid[y][x] == '1') {
                    dfs(y, x, grid);
                    count++;
                }
            }
        }
        return count;
    }

}
