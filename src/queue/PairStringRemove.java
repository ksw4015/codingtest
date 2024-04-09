package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 짝지어 제거하기
 *
 * 한방에 품 ㅋㄷ
 */
public class PairStringRemove {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0 ; i < len ; i++) {
                if(stack.isEmpty()) {
                    stack.push(queue.poll());
                } else {
                    if(stack.peek() == queue.peek()) {
                        queue.poll();
                        stack.pop();
                    } else {
                        stack.push(queue.poll());
                    }
                }
            }
            if(stack.size() == len) {
                return 0;
            } else {
                while (!stack.isEmpty()) {
                    queue.add(stack.pollLast());
                }
            }
        }
        if(queue.isEmpty()) {
            answer = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        PairStringRemove T = new PairStringRemove();
        System.out.println(T.solution("baabaa"));
        System.out.println(T.solution("cdcd"));
    }
}
