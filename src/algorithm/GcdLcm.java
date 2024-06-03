package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수, 최소공배수 알고리즘
 *
 * feat 유클리드 호제법
 *
 * 예제문제 백준 2609
 */
public class GcdLcm {
    /*
        A,B의 최소공배수
        유클리드 호제법
        1. A * B / Gcm(A, B)
     */
    public int Lcm(int a, int b) {
        int gcd = Gcd(a, b);
        return a * b / gcd;
    }

    /*
        A, B의 최대공약수
        1. A / B 의 나머지 C를 구함
        2. 1의 B와 나머지인 C로 1의 계산을 나머지가 0일때까지 반복한다.
     */
    public int Gcd(int a, int b) {
        int c;
        while (true) {
            c = a % b;
            if(c == 0)
                break;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        GcdLcm T = new GcdLcm();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(T.Gcd(a, b));
    }
}
