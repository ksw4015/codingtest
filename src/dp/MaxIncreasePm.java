package dp;

import java.util.Scanner;

public class MaxIncreasePm {

    static int[] dy; // 다이내믹 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        dy = new int[n];
        dy[0] = 1;
        int answer = 0;
        for(int i = 1 ; i < n ; i++) {
            int max = 0;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max+1;
            answer = Math.max(dy[i], answer);
        }

        System.out.println(answer);
    }
}
