package greedy;

import java.util.*;

public class WeddingSupport {
    private static class Time {
        int start;
        char state;
        public Time(int start, char state) {
            this.start = start;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> times = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            times.add(new Time(s, 's'));
            times.add(new Time(e, 'e'));
        }
        times.sort((o1, o2) -> {
            if (o1.start == o2.start)
                return o1.state - o2.state;
            return o1.start - o2.start;
        });

        System.out.println(times);

        int answer = 0;
        int sum = 1;
        for(int i = 1 ; i < times.size() ; i++) {
            if(times.get(i).state == 's') {
                sum += 1;
                answer = Math.max(answer, sum);
            } else {
                sum -= 1;
            }
        }

        System.out.print(answer);
    }
}
