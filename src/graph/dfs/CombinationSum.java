package graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> path, int[] candidates, int index, int target) {
        int sum = 0;
        for(Integer number : path) {
            sum += number;
        }
        if(sum == target) {
            results.add(new ArrayList<>(path));
            return;
        }

        for(int i = index ; i < candidates.length ; i++) {
            if(sum < target) {
                path.add(candidates[i]);
                dfs(results, path, candidates, i, target);
                path.remove(path.size() - 1);
            }
        }
    }

}
