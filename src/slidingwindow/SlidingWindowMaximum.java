package slidingwindow;

import java.util.*;

/**
 * LeetCode 239
 * 슬라이딩 윈도우안에 있는 Sub Array의 최대값들을 리턴
 *
 * 일반적인 반복문으로는 타임아웃 발생
 * max값을 구하는 부분을 최적화해야되는데
 * 그러기 위해 데크를 활용함
 */
public class SlidingWindowMaximum {

    /*
        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        Output: [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.add(i);
            if(i >= k-1)
                results.add(nums[dq.peek()]);
        }
        System.out.println(results);
        return results.stream().mapToInt(i -> i).toArray();
    }

    /*
        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        Output: [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int i=0, j=0;

        List<Integer> results = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        while(j < nums.length)
        {
            while(!q.isEmpty() && q.peekLast() < nums[j])
                q.removeLast();
            q.add(nums[j]);
            // 처음 슬라이딩 윈도우 사이즈에 도달하기 전까지 j값 증가
            if(j - i + 1 < k) {
                j++;
            } else {
                // 데크의 맨앞은 결과값 저장
                results.add(q.peek());
                // 데크의 맨 앞과 현재 윈도우의 시작 포지션의 값이 같으면 데크 맨앞 삭제
                if(nums[i] == q.peek())
                    q.remove();
                i++;
                j++;
            }
        }
        return results.stream().mapToInt(i1 -> i1).toArray();
    }

    public static void main(String[] args) {
        SlidingWindowMaximum T = new SlidingWindowMaximum();
        T.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        T.maxSlidingWindow(new int[]{1,2,3}, 2);
    }

}
