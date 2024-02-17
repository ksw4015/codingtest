package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestRange {

    public void solution(String s, char c) {
        List<Integer> results = new ArrayList<>();
        int left = 0;
        for(int right = 0 ; right < s.length() ; right++) {
            if(s.charAt(right) == c) {
                while(left<=right) {
                    int range = right-left;
                    results.add(range);
                    left++;
                }
            }
        }
        System.out.println(results);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ShortestRange shortestRange = new ShortestRange();
        shortestRange.solution(input[0], input[1].charAt(0));
    }

}
