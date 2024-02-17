package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스
 * 더 맵게
 *
 * 모든 음식의 스코빌 지수가 K 이상될때까지 섞어야되는 최소횟수
 * 스코빌 지수를 구하는 식
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 */
public class MoreHot {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville) {
            pq.add(sco);
        }
        // or 조건이 TestCase 18 통과용
        if(K == 0 || pq.peek() >= K)
            return 0;
        int answer = 1;  // 섞어야되는 횟수
        while (pq.size() >= 2) {
            pq.add(pq.poll() + (pq.poll() * 2));
            if(pq.peek() >= K)
                return answer;
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("" + solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
