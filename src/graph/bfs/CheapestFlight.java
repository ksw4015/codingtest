package graph.bfs;

import java.util.*;

public class CheapestFlight {

    /*
        Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        n = 정점개수, flights = 경로, src = 시작정점, dst = 종료정점, k = 경유지개수
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] f : flights) {
            graph.putIfAbsent(f[0], new HashMap<>());
            graph.get(f[0]).put(f[1], f[2]);
        }
        // 다익스트라 알고리즘에서 살짝 변형
        // 우선순위큐에 (도착지, 소요시간)이 아닌, (도착지, 소요시간(여기선 비용), 남은경로 개수)가 필요해서 List로 저장한다
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(o -> o.get(1)));
        pq.add(Arrays.asList(src, 0, 0));  // 시작점, 비용, 남은경로

        // 결과 저장이 필요없어 dist 변수(Map<Integer, Integer>) 는 사라졋다
        // 하지만, 타임아웃이 발생하여 방문한 경로 저장이 필요해 다시 만든다
        Map<Integer, Integer> visited = new HashMap<>();
        while (!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            int u = curr.get(0);
            int price_u = curr.get(1);
            int k_u = curr.get(2);  // 남은 경로

            if(u == dst)
                return price_u;

            // 비용은 제외하고 남은경로만 저장
            visited.put(u, k_u);
            // 경로 이내에 있으면 반복
            if(k_u <= k) {
                k_u += 1; // 반복수 증가
                if(graph.containsKey(u)) {
                    for(Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        if(!visited.containsKey(v.getKey()) || k_u < visited.get(v.getKey())) {
                            int alt = price_u + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, k_u));
                        }
                    }
                }
            }
        }

        return -1;
    }

}
