package slidingwindow;

public class MaximumContinuousPermutation {

    /*
        k = 2
        1 1 0 0 1 1 0 1 1 0 1 1 0 1
     */
    private int solution(int k, int[] n) {
        int answer = 0;
        int left = 0;
        int cnt = 0;
        for(int right = 0 ; right < n.length ; right++) {
            if (n[right] == 0)
                cnt++;
            while (k < cnt) {   // 2 < 3 right = 6
                if (n[left] == 0)  // left 0 1 2
                    cnt--; // 2
                left++; // left 1 2 3
            }
            answer = Math.max(answer, right - left + 1);
            System.out.println(answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumContinuousPermutation T = new MaximumContinuousPermutation();
        T.solution(2, new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1});
    }

}
