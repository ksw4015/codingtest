package recursion;

/**
 * 피보나치 수열 재귀 구현
 * 메모이제이션
 *
 * 면접에서 라이브 코딩문제로 자주 출제되니
 * 이해하고 외우자
 *
 * 1. 배열과 반복문으로 구현
 * 2. 재귀로 구현
 * 3. 시간, 공간 둘다 배렬이 우위에 있는듯
 */
public class Fibonacci {
    // 메모이제이션
    // 재귀가 그래프 처럼 뻗을때 이미 구해져있는 값이면 그 값을 리턴
    static int[] fibo;

    private static int fibonacci(int n) {
        if(fibo[n] > 0)
            return fibo[n];
        if(n == 1 || n == 2)
            return fibo[n] = 1;
        return fibo[n] = fibonacci(n-2) + fibonacci(n-1);
    }

    public static void main(String[] args) {
        int n = 40;
        fibo = new int[n+1];
        fibonacci(n);
        for(int i = 1 ; i <= n ; i++) {
            System.out.println(fibo[i]);
        }
    }
}
