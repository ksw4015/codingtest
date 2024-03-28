package greedy;

import java.util.*;

/**
 * 최단거리 알고리즘 (다익스트라)
 *
 * 가중치 그래프
 * 시작점, 도착점, 비용
 */
public class ClosestDistanceAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;  // 시작점은 0으로 초기화

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            graph.putIfAbsent(s, new HashMap<>());
            graph.get(s).put(e, c);
        }

        // 값기준 오름차순 정렬
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(1, 0));
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> curr = pq.poll();
            int now = curr.getKey();
            int cost = curr.getValue();
            if(cost > dis[now])
                continue;
            if(graph.containsKey(now)) {
                for (Integer key : graph.get(now).keySet()) {
                    if (dis[key] > cost + graph.get(now).get(key)) {
                        dis[key] = cost + graph.get(now).get(key);
                        pq.add(new AbstractMap.SimpleEntry<>(key, cost + graph.get(now).get(key)));
                    }
                }
            }
        }

        if(dis[n] < Integer.MAX_VALUE) {
            System.out.println(dis[n]);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

}
