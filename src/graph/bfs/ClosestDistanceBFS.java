package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 7*7 격자판에서
 * 최단거리 구하기
 */
public class ClosestDistanceBFS {

    static int[][] dis;
    static int[][] board;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1,1));
        board[x][y] = 1;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for(int i = 0 ; i < dx.length ; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;
                    // board 체크 해제 X
                }
            }
        }
    }

    public static void main(String[] args) {
        dis = new int[8][8];
        board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0},
        };
        bfs(1, 1);
        if(dis[7][7] > 0) {
            System.out.println(dis[7][7]);
        } else {
            System.out.println(-1);
        }
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
