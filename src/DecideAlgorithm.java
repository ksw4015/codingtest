import java.util.Arrays;
import java.util.Scanner;

public class DecideAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine().split(" ")[1]);
        String[] input = sc.nextLine().split(" ");
        int[] songs = new int[input.length];
        for(int i = 0 ; i < input.length ; i++) {
            songs[i] = Integer.valueOf(input[i]);
        }
        System.out.print(solution(songs, n));
    }

    private static int solution(int[] songs, int n) {
        int answer = 0;
        int left = Arrays.stream(songs).max().getAsInt();  // 가장 긴 길이의 노래 길이
        int right = Arrays.stream(songs).sum();  // 모든 노래 길이의 합
        // 이분탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            if(count(songs, mid) <= n) {  // n장 보다 같거나 작은경우
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static int count(int[] songs, int capa) {
        int cnt = 1, sum = 0;
        for(int i : songs) {
            if(sum + i > capa) {  // 노래길이의 합이 용량을 초과할경우
                cnt++;  // 장 수를 하나 늘리고
                sum = i;  // 새로운 DVD에 기록
            } else {
                sum += i; // DVD 용량에 여유가 있는경우 추가
            }
        }
        return cnt;
    }
}
