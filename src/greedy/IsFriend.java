package greedy;

import java.util.*;

/**
 * 친구인가 (Union-find)
 */
public class IsFriend {

    /*
        Union-Find 알고리즘
        서로소 집합
     */
    static int[] unf;
    public static int find(int v) {
        if(v==unf[v])
            return v;
        return unf[v] = find(unf[v]);  // 메모이제이션? 경로압축
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb)
            unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];

        for(int i = 1 ; i <= n ; i++) {
            unf[i] = i;
        }
        for(int i = 1 ; i <= m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
/*
        ArrayList<FriendShip> friends = new ArrayList<>();
        for(int i = 0 ; i <= m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends.add(new FriendShip(a, b));
        }

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < friends.size() - 1 ; i++) {
            FriendShip f = friends.get(i);
            graph.putIfAbsent(f.a, new ArrayList<>());
            graph.get(f.a).add(f.b);
            graph.putIfAbsent(f.b, new ArrayList<>());
            graph.get(f.b).add(f.a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(friends.get(friends.size() - 1).a);

        int[] chk = new int[n + 1];
        chk[friends.get(friends.size() - 1).a] = 1;
        while (!queue.isEmpty()) {
            if(chk[friends.get(friends.size()-1).b] != 0) {
                System.out.print("YES");
                return;
            }
            Integer curr = queue.poll();
            if(graph.containsKey(curr)) {
                for (Integer f : graph.get(curr)) {
                    if(graph.containsKey(f)) {
                        for(Integer f2 : graph.get(f)) {
                            if (chk[f2] == 0) {
                                queue.add(f);
                                chk[f2] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.print("NO");
*/
    }

    private static class FriendShip {
        int a;
        int b;
        public FriendShip(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "FriendShip[" +
                    "a=" + a +
                    ", b=" + b +
                    ']';
        }
    }
}
