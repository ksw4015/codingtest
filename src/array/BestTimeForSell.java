package array;

public class BestTimeForSell {
    public static int bestPrice(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int p : prices) {
            min = Math.min(min, p);  // 선행 하면서 저점 찾기
            max = Math.max(max, p - min);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("" + bestPrice(new int[]{7,1,5,3,6,4}));
        System.out.println("" + bestPrice(new int[]{7,6,4,3,1}));
    }
}
