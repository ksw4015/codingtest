package graph.dfs;

public class DuplicatePermutation {
    static int pm[];
    static int n, m;

    private static void dfs(int index) {
        if(index == 2) {
            System.out.println(pm[0] + " " + pm[1]);
            return;
        }

        for(int i = 1 ; i <= n ; i++) {
            pm[index] = i;
            dfs(index + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        m = 2;
        pm = new int[n];
        dfs(0);
    }

}
