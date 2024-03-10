package graph.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCow {
    private static int solution(int n, int k) {
        int[] dir = {-1, 1, 5};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int lv = 0;
        boolean[] check = new boolean[40];
        while (true) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int poll = queue.poll();
                for(int j = 0 ; j < dir.length ; j++) {
                    int nx = poll + dir[j];
                    if(nx == k)
                        return lv;
                    if(nx >= 1 && nx <= 10000 && !check[nx]) {
                        queue.add(nx);
                    }
                }
            }
            lv++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }
}
