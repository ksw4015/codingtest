package recursion;

public class Factorial {
    /**
     * n까지의 곱을 재귀로 구현
     * @param n
     * @return
     */
    private int factorial(int n) {
        if(n == 1)
            return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Factorial t = new Factorial();
        System.out.print(t.factorial(10));
    }
}
