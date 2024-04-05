package graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 타일점프 BFS
 */
public class TileJump {
    private class Jump {
        int distance;
        int count;
        public Jump(int distance, int count) {
            this.distance = distance;
            this.count = count;
        }
    }

    public int solution(int[] nums){
        int answer = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(i+1, nums[i]);
        }
        Queue<Jump> q = new LinkedList<>();
        q.add(new Jump(1, 0)); // 시작점
        while (!q.isEmpty()) {
            Jump curr = q.poll();
            if(curr.distance == nums.length) {
                answer = Math.min(answer, curr.count);
                break;
            }
            if(map.containsKey(curr.distance)) {
                for(int i = 1 ; i <= map.get(curr.distance) ; i++) {
                    q.add(new Jump(curr.distance + i, curr.count + 1));
                }
            }
        }

        if(answer == Integer.MAX_VALUE)
            return -1;

        return answer;
    }

    /**
     * 강의 해설 코드
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int n = nums.length;
        int[] chk = new int[n+1];  // 도착 지점 체크
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 시작점 삽입
        chk[1] = 1;  // 시작점 체크

        int answer = 0; // Level
        while (!q.isEmpty()) {
            int len = q.size();
            // BFS 탐색 이기때문에 Q의 크기만큼 반복
            for(int i = 0 ; i < len ; i++) {
                int p = q.poll();
                // 현재 지점에서 점프 가능한 곳 탐색 후 큐에 삽입
                for(int j = 1 ; j <= nums[p-1] ; j++) {
                    int nx = j + p;  // 점프한 지점
                    if(nx == n)  // 목적지에 도달한 경우 정답 리턴
                        return answer+1;
                    if(nx < n+1 && chk[nx] == 0) {  // 점프한 지점이 도착점을 지나지 않고, 도착한 적이 없으면 큐에 삽입
                        chk[nx] = 1;
                        q.add(nx);
                    }
                }
            }
            answer++;  // Level 탐색 종료시 1 증가
        }

        return -1;
    }

    public static void main(String[] args){
        TileJump T = new TileJump();
        System.out.println(T.solution2(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution2(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution2(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution2(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution2(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
