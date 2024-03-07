package sort;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++) {
            input[i] = Integer.valueOf(s[i]);
        }

        for(int i = 0 ; i < input.length - 1; i++) {
            int idx = i;
            for(int j = i+1 ; j < input.length ; j++) {
                if(input[j] < input[idx]) {
                    idx = j;
                }
            }
            int tmp = input[idx];
            input[idx] = input[i];
            input[i] = tmp;
        }

        for(int i : input) {
            System.out.print(i + " ");
        }
    }

}
