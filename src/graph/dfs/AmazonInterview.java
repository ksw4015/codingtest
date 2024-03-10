package graph.dfs;

import java.util.ArrayList;

/**
 * N개의 자연수 집합이 주어지면
 * 서로소 집합으로 2개의 부분 집합을 만들고
 * 두 집합의 합이 같으면 YES 다르면 NO 출력
 */
public class AmazonInterview {
    int total;
    String result = "NO";

    private void dfs(int[] numbers, int lv, int sum) {
        if(total/2 < sum)
            return;
        if(lv == numbers.length) {
            if(total - sum == sum) {
                result = "YES";
            }
            return;
        }
        dfs(numbers, lv + 1, sum + numbers[lv]);
        dfs(numbers, lv + 1, sum);
    }

    public static void main(String[] args) {
        AmazonInterview T = new AmazonInterview();
        int[] input = new int[]{1, 3, 5, 6, 7, 10};
        for(int i : input) {
            T.total += i;
        }
        T.dfs(input, 0, 0);
        System.out.println(T.result);
    }

}
