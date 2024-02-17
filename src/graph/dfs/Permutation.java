package graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int i : nums) {
            lst.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), lst);
        return result;
    }

    /**
     *
     * @param result 정답이되는 List 값
     * @param prevElements 현재(이전) 노드 List
     * @param elements 남은 노드 List
     */
    private void dfs(List<List<Integer>> result, List<Integer> prevElements, List<Integer> elements) {
        if(elements.isEmpty()) {
            List<Integer> resultElements = new ArrayList<>();
            for(Integer i : prevElements) {
                resultElements.add(i);
            }
            result.add(resultElements);
        }

        for(Integer i : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(i);

            prevElements.add(i);
            dfs(result, prevElements, nextElements);
            prevElements.remove(i);
        }
    }
}
