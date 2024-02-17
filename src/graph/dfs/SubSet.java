package graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    /*
        [1,2,3]
        [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> path, int[] nums, int index, int size) {
        if(path.size() > nums.length)
            return;
        if(path.size() == size) {
            results.add(new ArrayList<>(path));
        }
        for(int i = index ; i < nums.length ; i++) {
            path.add(nums[i]);
            dfs(results, path, nums, i+1, size+1);
            path.remove(path.size() - 1);
        }
    }

    private void dfs(List<List<Integer>> results, List<Integer> path, int[] nums, int index) {
        // 별도의 종료 조건이 필요없음
        results.add(new ArrayList<>(path));
        for(int i = index ; i < nums.length ; i++) {
            path.add(nums[i]);
            dfs(results, path, nums, i+1);
            path.remove(path.size() - 1);
        }
    }

}
