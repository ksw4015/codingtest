package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TomatoProblem {

    static int[][] box = {
            {0, 0, -1, 0, 0, 0},
            {0, 0, 1, 0, -1, 0},
            {0, 0, -1, 0, 0, 0},
            {0, 0, 0, 0, -1, 1}
    };
    static int[][] day = new int[4][6];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        for(int i = 0 ; i < box.length ; i++) {
            for(int j = 0 ; j < box[0].length ; j++) {
                if(box[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                Tomato poll = queue.poll();
                for(int j = 0 ; j < dx.length ; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if(nx >= 0 && nx <= box.length-1 && ny >= 0 && ny <= box[0].length - 1 && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        day[nx][ny] = day[poll.x][poll.y] + 1;
                        queue.add(new Tomato(nx, ny));
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0 ; i < box.length ; i++) {
            for(int j = 0 ; j < box[0].length ; j++) {
                if(box[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, day[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(bfs());
    }

    private static class Tomato {
        int x;
        int y;
        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
