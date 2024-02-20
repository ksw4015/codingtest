package graph.dfs;

import java.util.*;

/**
 * LeetCode 207
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new LinkedList<>());
            map.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for(Integer finish : map.keySet()) {
            if(!dfs(map, finish, takes, taken))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Integer finish, List<Integer> takes, List<Integer> taken) {
        if(takes.contains(finish))
            return false;
        if(taken.contains(finish))
            return true;
        if(map.containsKey(finish)) {
            takes.add(finish);
            for(Integer notVisit : map.get(finish)) {
                if(!dfs(map, notVisit, takes, taken)) {
                    return false;
                }
            }
            takes.remove(finish);
            taken.add(finish);
        }
        return true;
    }

    public boolean canFinishTwo(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int e = prerequisites.length;
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[V];
        int cnt = 0 ;

        // 인접리스트
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < e ; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1]; // edge a -> b
            adj.get(a).add(b);
            indegree[b]++;
        }

        for(int i = 0 ; i < V ; i++) {
            if(indegree[i] == 0){
                cnt++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj.get(curr)){
                indegree[i]--;
                if(indegree[i] == 0){
                    cnt++;
                    q.offer(i);
                }
            }
        }

        return cnt == V ; // means no cycle
    }

    public static void main(String[] args) {
        System.out.println(
                new CourseSchedule().canFinish(
                        2,
                        new int[][]{
                                {1,0}
                        }));
    }

}
