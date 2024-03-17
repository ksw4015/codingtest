package graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * dfs로 피자집의 조합을 구하고
 * 조합당 도시의 집들과 배달거리를 구한다
 * 조합당 모든 집들과 최소 배달거리
 */
public class PizzaDelivery {
    static int[][] city;
    static int distance = 1000;

    static Point[] pizzaCom;

    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> pizzas = new ArrayList<>();

    private void dfs(int lv, int start) {
        if(lv == pizzaCom.length) {
            // 도시의 모든 집들의 피자집까지 최소거리의 합
            int sum = 0;
            for(Point h : houses) {
                // 한 집에서 각 피자집 까지의 거리 중 최소 거리
                int dis = Integer.MAX_VALUE;
                for (Point p : pizzaCom) {
                    dis = Math.min(dis, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
                }
                sum += dis;
            }
            // 답
            distance = Math.min(distance, sum);
        } else {
            for(int i = start ; i < pizzas.size() ; i++) {
                pizzaCom[lv] = pizzas.get(i);
                dfs(lv + 1, i + 1);
            }
        }
    }

    private void solution() {
        for(int i = 0 ; i < city.length ; i++) {
            for(int j = 0 ; j < city[0].length ; j++) {
                if(city[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if(city[i][j] == 2){
                    pizzas.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
    }

    public static void main(String[] args) {
        PizzaDelivery T = new PizzaDelivery();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        city = new int[n][n];
        pizzaCom = new Point[m];

        for(int i = 0 ; i < city.length ; i++) {
            for(int j = 0 ; j < city[0].length ; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        T.solution();
        System.out.println(distance);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
