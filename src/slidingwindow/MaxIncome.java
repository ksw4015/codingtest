package slidingwindow;

import java.util.Scanner;

public class MaxIncome {

    private static int maxIncome(int[] incomes, int k) {
        int max = 0; // 126
        int curr = 0; // 126
        for(int i = 0 ; i < incomes.length - k ; i++) {
            if(i < k) {
                max += incomes[i];
                curr += incomes[i];
            } else {
                curr = curr - incomes[i-k] + incomes[i];
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        int[] incomes = new int[n];
        String[] input2 = sc.nextLine().split(" ");
        for(int i = 0 ; i < incomes.length ; i++) {
            incomes[i] = Integer.valueOf(input2[i]);
        }

        System.out.println(maxIncome(incomes, k));
    }
}
