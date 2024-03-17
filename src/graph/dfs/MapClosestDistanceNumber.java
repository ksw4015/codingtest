package graph.dfs;

public class MapClosestDistanceNumber {

    static int[] dx = {1, 0, -1, 0};  // 남, 북
    static int[] dy = {0, 1, 0, -1};  // 동, 서

    static int answer = 0;
    static int[][] map = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
    };

    private static void dfs(int x, int y) {
        if(x == 7 && y == 7) {
            answer++;
        } else {
            // 동,서,남,북
            for(int i = 0 ; i < dx.length ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    dfs(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        dfs(1, 1);
        System.out.println(answer);
    }

}
