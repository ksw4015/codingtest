package graph.bfs;

import java.util.*;

public class BasicBFSClosestDistance {
    int[] ch = new int[10];
    int[] dist = new int[10];

    private void bfs(Map<Integer, List<Integer>> list) {
        Queue<Integer> queue = new LinkedList<>();
        ch[1] = 1;
        queue.add(1);  // 시작점 삽입
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if(list.containsKey(n)) {
                for(Integer i : list.get(n)) {
                    if(ch[i] == 0) {
                        ch[i] = 1;
                        queue.add(i);
                        dist[i] = dist[n] + 1;
                    }
                }
            }
        }

        for(int i = 2 ; i < dist.length ; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3}, {1, 4}, {2, 1}, {2, 5}, {3, 4},
                {4, 5}, {4, 6}, {6, 2}, {6, 5}
        };

        Map<Integer, List<Integer>> list = new HashMap<>();
        for(int[] in : input) {
            list.putIfAbsent(in[0], new ArrayList<>());
            list.get(in[0]).add(in[1]);
        }

        BasicBFSClosestDistance t = new BasicBFSClosestDistance();
        t.bfs(list);
    }
}
