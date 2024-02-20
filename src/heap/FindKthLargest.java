package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 이진 힙을 직접구현 하는 문제는 나오지 않음
 * 우선순위 큐를 사용하여 푸는 문제들이 힙 문제라고 보면된다.
 *
 * 우선순위 큐의 내부 정렬 알고리즘이 힙정렬이다.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(Integer num : nums) {
            pq.add(num);
        }

        for(int i = 0 ; i < k ; i++) {
            int number = pq.poll();
            if(i == k - 1)
                return number;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
