package bst;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {

    private void binarySearch2(int[] numbers, int left, int right, int n) {
        int middle = left + (right - left) / 2;
        if(numbers[middle] > n) {
            binarySearch2(numbers, left, middle - 1, n);
            return;
        } else if(numbers[middle] < n) {
            binarySearch2(numbers, middle + 1, right, n);
            return;
        } else if(numbers[middle] == n){
            int idx = middle + 1;
            System.out.print(idx);
            return;
        }
        System.out.print("-1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        String[] in2 = sc.nextLine().split(" ");
        int[] input = new int[in2.length];
        int n = Integer.valueOf(in[1]);
        for(int i = 0 ; i < input.length ; i++) {
            input[i] = Integer.valueOf(in2[i]);
        }

        Arrays.sort(input);

        BinarySearch2 b = new BinarySearch2();
        b.binarySearch2(input, 0, input.length - 1, n);
    }

}
