package queue;

import java.util.*;

/**
 * 스택,큐 강의
 * 공주 구하기
 * 1부터 n까지 지속적으로 순회하면서 k번째 숫자를 꺼내다가
 * 1개 남으면 반환
 */
class SaveThePrincess {
    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (queue.size() > 1) {
            cnt++;
            int poll = queue.poll();
            if(cnt != k) {
               queue.add(poll);
            } else {
                cnt = 0;
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        System.out.print(solution(Integer.valueOf(in[0]), Integer.valueOf(in[1])));
    }
}

