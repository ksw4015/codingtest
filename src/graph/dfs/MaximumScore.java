package graph.dfs;

public class MaximumScore {
    static int max = 0;
    static int limit;
    private static void dfs(int[][] problems, int sum, int time, int lv) {
        if(time > limit)
            return;
        if(problems.length == lv) {
            max = Math.max(max, sum);
            return;
        }
        dfs(problems, sum+problems[lv][0], time+problems[lv][1], lv+1);
        dfs(problems, sum, time, lv+1);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{10, 5}, {25, 12}, {15, 8}, {6, 3}, {7, 4}};
        limit = 20;
        dfs(input, 0, 0, 0);
        System.out.println(max);
    }
}
