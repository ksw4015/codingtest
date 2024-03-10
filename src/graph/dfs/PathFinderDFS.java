package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathFinderDFS {
    static int[] check = new int[10];
    static int answer = 0;
    static int n = 0;
    static List<List<Integer>> results = new ArrayList<>();

    private static void dfs(int[][] graph, List<Integer> path, int v) {
        if(v == n) {
            answer++;
            System.out.println(answer);
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs(graph, path, i);
                    check[i] = 0;
                }
            }
        }
    }

    /**
     *
     * @param listMap 그래프의 인접 리스트
     * @param v
     * @param path
     */
    private static void dfs2(Map<Integer, List<Integer>> listMap, int v, List<Integer> path) {
        if(v == n) {
            answer++;
            System.out.println(answer);
            ArrayList<Integer> result = new ArrayList<>(path);
            result.add(v);
            results.add(result);
        } else {
            if(listMap.containsKey(v) && check[v] == 0) {
                check[v] = 1;
                path.add(v);
                for(int k : listMap.get(v)) {
                    dfs2(listMap, k, path);
                }
                path.remove(path.size() - 1);
                check[v] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,0,1,0,1},
                {0,0,0,0,1,0},
                {0,0,1,0,0,1},
                {0,0,0,0,0,0}
        };
        n = 5;
//        dfs(graph, new ArrayList<>(), 1);

        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for(int i = 1 ; i <= 4; i++) {
            for(int j = 1 ; j < graph[i].length ; j++) {
                if(graph[i][j] == 1) {
                    if (!listMap.containsKey(i)) {
                        listMap.put(i, new ArrayList<>());
                    }
                    listMap.get(i).add(j);
                }
            }
        }
        dfs2(listMap, 1, new ArrayList<>());
        System.out.println(results);
    }
}
