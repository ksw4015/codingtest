package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoordinateSort {
    private void solution(int[][] coord) {
        Arrays.sort(coord, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for(int[] n : coord) {
            System.out.println(n[0] + " " + n[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[][] coord = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            String[] input = sc.nextLine().split(" ");
            coord[i] = new int[]{Integer.valueOf(input[0]), Integer.valueOf(input[1])};
        }
        new CoordinateSort().solution(coord);
    }
}
