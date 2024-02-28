package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Hash 강의
 * 매출액의 종류
 */
public class KindOfRevenue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        String[] input2 = sc.nextLine().split(" ");
        int[] numbers = new int[input2.length];
        for(int i = 0 ; i < input2.length ; i++) {
            numbers[i] = Integer.parseInt(input2[i]);
        }
        solution(numbers, k);
    }

    private static void solution(int[] numbers, int k) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i = 0 ; i < k ; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for(int i = k ; i < numbers.length ; i++) {
            map.put(numbers[i-k], map.get(numbers[i-k]) - 1);
            if(map.get(numbers[i-k]) <= 0)
                map.remove(numbers[i-k]);
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
    }
}
