package queue;

import java.util.*;

public class EmergencyRoom {
    public static class Item {
        int index;
        int value;
        public Item(int i, int v) {
            index = i;
            value = v;
        }
    }

    private static int solution(int[] p, int k) {
        int answer = 0;
        Queue<Item> pq = new LinkedList<>();
        for(int i = 0 ; i < p.length ; i++) {
            pq.add(new Item(i, p[i]));
        }

        while (true) {
            Item poll = pq.poll();
            for(Item person : pq) {  // index로 도는 for문은 안되는데 이건됨
                if(poll.value < person.value) {
                    pq.add(poll);
                    poll = null;
                    break;
                }
            }
            answer++;
            if(poll != null && poll.index == k)
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        String[] in2 = sc.nextLine().split(" ");
        int[] persons = new int[in2.length];
        for(int i = 0 ; i < in2.length ; i++) {
            persons[i] = Integer.valueOf(in2[i]);
        }
        System.out.print(solution(persons, Integer.valueOf(in[1])));
    }
}
