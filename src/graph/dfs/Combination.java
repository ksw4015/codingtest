package graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    /*
        n = 4, k = 2
        1 ~ 4까지의 정수(자연수)로 k개의 각기다른 조합
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new LinkedList<>(), 1, n, k);
        return results;
    }

    /*
           dfs(결과 저장변수, 탐색경로 저장변수, ~~~)
     */
    private void dfs(List<List<Integer>> results, LinkedList<Integer> path, int start, int n, int k) {
        if(k == 0) {
            List<Integer> value = new ArrayList<>();
            for(Integer i : path) {
                value.add(i);
            }
            results.add(value);
            return;
        }
        for(int i = start ; i <= n ; i++) {
            path.add(i);
            dfs(results, path, i + 1, n, k - 1);  // 위의 return(종료 조건)에 걸리면 결과값에 하나 추가되고 빠져나온다
            path.removeLast(); // 탐색이 끝난 노드(LinkedList의 마지막 노드는 삭제하고 반복문을 통해 다음 노드를 넣는다)
        }
    }
}
