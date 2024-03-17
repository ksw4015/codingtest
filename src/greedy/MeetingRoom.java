package greedy;

import java.util.*;

/**
 * 입력값 숫자 만큼의 Meeting이 주어진다.
 * 각 회의가 겹치지 않게 최대 진행가능한 회의의 수를 구해라
 */
public class MeetingRoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Meeting(s, e));
        }
        // 끝나는 시간 오름 차순 우선
        // 끝나는 시간이 같은경우 시작시간 오름차순
        list.sort((o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        int answer = 1;
        Meeting curr = list.get(0);
        for(int i = 1 ; i < list.size() ; i++) {
            if(curr.end <= list.get(i).start) {
                curr = list.get(i);
                answer += 1;
            }
        }

        System.out.print(answer);
    }

    /*
        각 회의의 시작시간과 끝시간을 담고있는 클래스
     */
    private static class Meeting {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
