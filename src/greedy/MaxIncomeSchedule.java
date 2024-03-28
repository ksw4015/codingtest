package greedy;

import java.util.*;

/**
 * 최대 수입 스케쥴
 *
 */
public class MaxIncomeSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Schedule> schedules = new ArrayList<>();
        int maxDay = 0;
        for(int i = 0 ; i < n ; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            maxDay = Math.max(maxDay, d);
            schedules.add(new Schedule(m, d));
        }
        // 스케쥴은 시간 내림차순 정리
        Collections.sort(schedules, (o1, o2) -> o2.d - o1.d);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int income = 0;
        int j = 0; // break시 시작지점 유지하기위해 밖으로 빼논다
        for(int i = maxDay ; i >= 1 ; i--) {
            for( ; j < n ; j++) {
                if(schedules.get(j).d == i) {
                    pq.add(schedules.get(j).m);
                } else {
                    break;
                }
            }
            if(!pq.isEmpty())
                income += pq.poll();
        }

        System.out.print(income);
    }

    /**
     * 강의 클래스
     * m: 수업료
     * d: 기한
     */
    private static class Schedule {
        int m;
        int d;
        public Schedule(int m, int d) {
            this.m = m;
            this.d = d;
        }
    }
}
