package greedy;

import java.util.*;

/**
 * LeetCode 406
 *
 * 도식 그려서 일정한 규칙을 찾은 뒤,
 * 우선순위큐 사용
 */
public class QueueReconstructByHeight {
    private static int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] != o2[0]) {
                return o2[0] - o1[0];  // 키는 내림차순
            } else {
                return o1[1] - o2[1];  // 앞에 나보다 같거나 큰 사람의 숫자는 오름차순
            }
        });
        pq.addAll(Arrays.asList(people));

        List<int[]> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        for(int[] re : reconstructQueue(input)) {
            System.out.print("[" + re[0] + ", " + re[1] + "] ");
        }
    }
}
