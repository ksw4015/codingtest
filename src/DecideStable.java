import java.util.Arrays;
import java.util.Scanner;

public class DecideStable {
    private static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i]-ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    private static int solution(int[] arr, int n) {
        int answer = 0;
        int left = arr[0];
        int right = arr[arr.length-1];
        while (left <= right) {
            int mid = (left+right)/2;
            if(count(arr, mid) >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");
        int n = Integer.valueOf(input[1]);
        int[] arr = new int[input2.length];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = Integer.valueOf(input2[i]);
        }
        Arrays.sort(arr);
        System.out.print(solution(arr, n));
    }
}
