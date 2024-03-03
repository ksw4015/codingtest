package greedy;

import java.util.*;

/**
 * LeetCode 621
 *
 * 문자열 빈도수를 우선순위큐에 삽입 후
 * 반복문 실행하면서 처리하는데 이해안됨
 */
public class TaskScheduler {
    private static int leastInterval(char[] tasks, int n) {
        // 문자열 빈도수 체크
        int[] freqs = new int[26]; // 알바벳 개수만큼 생성
        for(char c : tasks) {
            freqs[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int f : freqs) {
            if(f > 0)
                pq.add(f);
        }

        int result = 0;
        while (true) {
            int intervals = 0;
            List<Integer> list = new ArrayList<>();
            // 큐가 빌때까지 반복
            while (!pq.isEmpty()) {
                int frequency = pq.poll();
                // 인터벌이 n + 1이 될때까지 큐에서 추출
                if(intervals < n + 1) {
                    intervals++;
                    result++;
                    if(frequency > 1)
                        list.add(frequency - 1);
                } else {
                    list.add(frequency);
                }
            }
            if(list.isEmpty())
                break;
            pq.addAll(list);
            result += n + 1 - intervals;
        }
        return result;
    }

    private static int solution(char[] tasks, int n) {
        /*
            알파벳 빈도수 만큼 저장
         */
        if(n == 0)
            return tasks.length;
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int c : count){
            if(c < 1) continue;
            pq.add(c);
        }

        int max = Integer.MIN_VALUE;
        int place = 0;
        while(!pq.isEmpty()){
            int m = (pq.poll() * (n + 1)) - n + place;
            max = Math.max(max, m);
            place++;
        }
        return Math.max(max, tasks.length);
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
        System.out.println(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 3));
        System.out.println(leastInterval(new char[]{'A', 'B'}, 2));
    }
}
