package greedy;

import java.util.*;

/**
 * 씨름선수
 *
 * n명의 지원자를
 * 각각 1:1 비교해서
 * 해당 선수보다 키와 몸무게 둘 다 큰 선수가 있으면 해당선수는 탈락
 */
public class SelectPlayer {

    private static void solution(List<Player> players) {
        int maxW = 0;
        Collections.sort(players, (o1, o2) -> o2.h - o1.h);
        maxW = players.get(0).w;
        int answer = 1;
        for(int i = 0 ; i < players.size() ; i++) {
            if(players.get(i).w > maxW) {
                answer++;
                maxW = players.get(i).w;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            players.add(new Player(h, w));
        }
        solution(players);
//        ArrayList<Player> result = new ArrayList<>();
//        for(int i = 0 ; i < players.size() ; i++) {
//            boolean pass = true;
//            for(int j = 0 ; j < players.size() ; j++) {
//                if(i != j) {
//                    if(players.get(i).h < players.get(j).h && players.get(i).w < players.get(j).w) {
//                        pass = false;
//                        break;
//                    }
//                }
//            }
//            if(pass)
//                result.add(players.get(i));
//        }
//        System.out.println(result.size());
    }

    private static class Player {
        int h;
        int w;
        public Player(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
