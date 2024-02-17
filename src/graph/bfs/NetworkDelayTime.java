package graph.bfs;

import java.io.IOException;
import java.util.*;

/**
 * Leetcode 743
 * 최단거리 (BFS)
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) throws IOException {
        // 노드별 도착지/소요시간 그래프
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));  // 초기값은 출발지

        // 최종 결과 저장
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();  // 가장 소요시간이 적은 순서로 진행
            int u = cur.getKey(); // 도착지
            int u_dist = cur.getValue();  // 소요시간
            if(!dist.containsKey(u)) {  // u(도착지)까지 아직 계산되지 않은 경우 계산진행
                dist.put(u, u_dist);
                if(graph.containsKey(u)) {  // 그래프 내에 u가 시작점인 경우 탐색
                    for(Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        int alt = v.getValue() + u_dist;
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }
                }
            }
        }
        if(dist.size() == n)
            return Collections.max(dist.values());
        return -1;
    }

}
