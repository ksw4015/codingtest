package graph.bfs;

import java.util.*;

/**
 * 프로그래머스
 * 게임 내 최단거리
 */
public class ClosestGameMap {

    static class Position {
        int x;
        int y;
        int distance;
        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
    public int solution(int[][] maps) {
        // 시작점 삽입
        pq.add(new Position(0, 0, 1)); // 0,0 도 한칸 진행으로 침
        Map<Integer, Position> dist = new LinkedHashMap<>(); // 순서유지?
        // 다익스트라
        while (!pq.isEmpty()) {
            Position curr = pq.poll();
            System.out.println("" + curr.x + ", " + curr.y + ", " + curr.distance);
            /*
                dist에 Key값은 y*1000+x
             */
            int distKey = curr.y * 1000 + curr.x;
            if(!dist.containsKey(distKey)) {
                dist.put(distKey, curr);
                // 동서남북 길찾기실행
                findPath(curr.x+1, curr.y, curr.distance, maps);
                findPath(curr.x-1, curr.y, curr.distance, maps);
                findPath(curr.x, curr.y+1, curr.distance, maps);
                findPath(curr.x, curr.y-1, curr.distance, maps);
            }
        }

        if(dist.containsKey(((maps.length - 1)*1000) + (maps[0].length-1))) {
            return dist.get(((maps.length - 1)*1000) + (maps[0].length-1)).distance;
        }
        return -1;
    }

    private void findPath(int x, int y, int distance, int[][] maps) {
        if(y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            System.out.println("findPath:: " + x + ", " + y + ", " + distance);
            maps[y][x] = 0;
            pq.add(new Position(x, y, distance + 1));
        }
    }

}
