package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 힙
 * 프로그래머스 힙 문제
 * 이중우선순위 큐 (레벨3)
 * 내가 푼 풀이가 책이랑 같아서 주석은 생략한다.
 */
public class DoublePriorityQueue {

    /*
        ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
        ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]
     */
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        for(String operation : operations) {
            String[] ops = operation.split(" ");
            String op = ops[0];
            String num = ops[1];
            if(op.equals("I")) {
                maxPq.add(Integer.valueOf(num));
                minPq.add(Integer.valueOf(num));
            } else {
                if(maxPq.isEmpty() || minPq.isEmpty())
                    continue;
                if(Integer.valueOf(num) == 1) {
                    Integer max = maxPq.poll();
                    minPq.remove(max);
                } else {
                    Integer min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }

        int[] answer = new int[2];
        if(!maxPq.isEmpty() && !minPq.isEmpty()) {
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = new DoublePriorityQueue().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        for(int i : result) {
            System.out.print(i + " ,");
        }
    }

}
