package greedy;

import java.util.*;

public class WonderLand2 {
    static int[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        chk = new int[n+1];  // 간선 체크

        Map<Integer, ArrayList<Vertex>> graph = new HashMap<>();
        for(int i = 0 ; i < m ; i++) {
            int v = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            // 무방향 그래프
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Vertex(end, cost));
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(end).add(new Vertex(v, cost));
        }

        int answer = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Vertex(1, 0));
        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();
            if(chk[curr.end] == 0) {
                chk[curr.end] = 1;
                answer += curr.cost;
                if(graph.containsKey(curr.end)) {
                    for(Vertex v : graph.get(curr.end)) {
                        if(chk[v.end] == 0) {
                            pq.add(v);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static class Vertex {
        int end;
        int cost;
        public Vertex(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}


