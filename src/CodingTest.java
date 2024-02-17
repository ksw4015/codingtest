import graph.bfs.ClosestGameMap;

import java.io.IOException;
import java.util.Scanner;

public class CodingTest {

    public static void main(String[] args) throws IOException {
        ClosestGameMap gm = new ClosestGameMap();
        int[][] input = new int[5][5];
        input[0] = new int[]{1,0,1,1,1};
        input[1] = new int[]{1,0,1,0,1};
        input[2] = new int[]{1,0,1,1,1};
        input[3] = new int[]{1,1,1,0,1};
        input[4] = new int[]{0,0,0,0,1};
        System.out.println("" + gm.solution(input));
    }

}
