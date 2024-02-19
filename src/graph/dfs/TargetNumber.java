package graph.dfs;

/**
 * 프로그래머스 고득점 Kit
 * DFS/BFS 타겟넘버
 *
 * 주어진 배열의 숫자를 모두 이용(덧셈,뺄셈)해 Target 숫자가 나오게하는 조합의 수
 */
public class TargetNumber {
    int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0 , 0, ans);
        return ans;
    }

    private void dfs(int[] numbers, int target, int index, int sum, int answer) {
        if(index == numbers.length - 1) {
            if(sum + numbers[index] == target || sum - numbers[index] == target) {
                ans++;
            }
            return;
        }
        dfs(numbers, target, index + 1, sum + numbers[index], answer);
        dfs(numbers, target, index + 1, sum - numbers[index], answer);
    }

    public static void main(String[] args) {
        TargetNumber t = new TargetNumber();
        System.out.println(t.solution(new int[]{1,1,1,1,1}, 3));
    }
}
