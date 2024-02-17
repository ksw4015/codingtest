package queue;

import java.awt.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosetPoint {

    /*
        Input: points = [[1,3],[-2,2]], k = 1
        Output: [[-2,2]]

        Input: points = [[3,3],[5,-1],[-2,4]], k = 2
        Output: [[3,3],[-2,4]]
     */
    public static int[][] kClosest(int[][] points, int k) {
        int[][] results = new int[k][];
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double o1Distance = Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2));
                double o2Distance = Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2));
                if(o1Distance == o2Distance)
                    return 0;
                else if(o1Distance > o2Distance)
                    return 1;
                else
                    return -1;
            }
        });
        for (int[] ints : points) {
            pq.add(new Point(ints[0], ints[1]));
        }

        for(int i = 0 ; i < k ; i++) {
            Point point = pq.poll();
            results[i] = new int[]{point.x, point.y};
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,3}, {-2,2}};
        int[][] result = kClosest(input, 1);
        for(int[] re : result) {
            System.out.println("[" + re[0] + "," + re[1] + "]");
        }
    }
}
