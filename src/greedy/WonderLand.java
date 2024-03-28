package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 원더랜드 문제
 * 모든 정점을 잇는 최소 비용 구하기
 *
 * 트리는 회로가 되면 안됨
 * 회로인지 판별하는 알고리즘으로 Union-Find 사용용 */
public class WonderLand {

    static int[] unf;

    private static int find(int v) {
        if(v == unf[v])
            return v;
        return unf[v] = find(unf[v]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb)
            unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) {
            unf[i] = i;
        }

        ArrayList<Edge> list = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Edge(v1, v2, cost));
        }

        int answer = 0;
        // 간선의 리스트는 Cost(비용)으로 정렬
        list.sort(Comparator.comparingInt(o -> o.cost));
        for(Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            // 회로가 아니면 비용 더하기
            if(fv1 != fv2) {
                answer += e.cost;
                // 두 정점을 union으로 묶는다
                union(e.v1, e.v2);
            }
        }

        System.out.println(answer);
    }
}

/*
    간선 정보 클래스
    시작정점, 끝 정점, 비용
 */
class Edge {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}
