package graph;

import java.util.*;

/**
 * Leetcode 2192
 */
public class GetAncestors {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> ancestorList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        // 노드의 진입차수 배열
        int[] degree = new int[n];
        // edges의 인접리스트 (그래프)
        List<List<Integer>> connections = new ArrayList<>();
        for(int i = 0;i<n;i++){
            connections.add(new ArrayList<>());
            ancestorList.add(new TreeSet<>());
        }
        for(int[] edge: edges){
            connections.get(edge[0]).add(edge[1]); // 인접리스트
            degree[edge[1]]++;  // 진입차수
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            // 진입차수가 0인 노드 큐에 삽입
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        // * 위상정렬 *
        // 진입차수가 0인 노드를 꺼내 연결된 간선을 제거한다. ex) degree[node] -= 1
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            // 큐에서 노드를 꺼내
            for(int node : connections.get(currNode)){
                ancestorList.get(node).addAll(new TreeSet<>(ancestorList.get(currNode)));
                ancestorList.get(node).add(currNode);
                degree[node]--;
                if(degree[node] == 0){ // 간선 제거 후 인접한 노드의 진입차수가 0이되면 큐에 삽입
                    queue.add(node);
                }
            }
        }
        for(TreeSet<Integer> set : ancestorList){
            list.add(new ArrayList<>(set));
        }
        return list;
    }

    public static void main(String[] args) {
        GetAncestors getAncestors = new GetAncestors();
        System.out.println(getAncestors.getAncestors(8, new int[][]{
                {0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7},{4, 6}
        }));
        System.out.println(getAncestors.getAncestors(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}
        }));
        System.out.println(getAncestors.getAncestors(9, new int[][]{
                {3,6},{2,4},{8,6},{7,4},{1,4},{2,1},{7,2},{0,4},{5,0},{4,6},
                {3,2},{5,6},{1,6}
        }));
    }
}
