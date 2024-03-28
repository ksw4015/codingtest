package dp;

import java.util.*;

public class HighestTower {
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];

        List<Stone> arr= new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Stone(a,h,w));
        }
        arr.sort((o1, o2) -> {
            if(o1.a == o2.a) {
                return o2.w - o1.w;
            }
            return o2.a - o1.a;
        });

        dy[0] = arr.get(0).h;
        int answer = 0;
        for(int i = 1 ; i < n ; i++) {
            int max = 0;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(arr.get(j).w >= arr.get(i).w) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    private static class Stone {
        int a;
        int h;
        int w;
        public Stone(int a, int h, int w) {
            this.a = a;
            this.h = h;
            this.w = w;
        }
    }
}
