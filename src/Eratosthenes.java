import java.util.ArrayList;
import java.util.List;

/**
 * 에라토스테네스의 체
 * n까지 자연수 중에서 소수 구하기
 *
 * 주어진 N보다 하나 더 큰 수의 빈 배열 생성 후
 * 반복문을 돌면서 배수 마다 1을 입력해서 체크
 */
public class Eratosthenes {

    /*
        n까지의 소수 개수 반환
     */
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];
        List<Integer> show = new ArrayList<>(); // 소수 출력용

        // 소수는 자기 자신과 1로만 나눌수 있는 숫자라 1은 제외한다
        // n까지 반복해야하기 때문에 ch 배열의 크기가 1더 큰 것 (Index 20까지)
        for(int i = 2 ; i <= n ; i++) {
            if(ch[i] == 0) {  // 2부터 시작 2는 무조건 소수
                answer++;
                show.add(i);
                for(int j = i ; j <= n ; j+=i) { // j는 i의 배수만큼 증가 ex) 2, 4, 5 ... 20
                    ch[j] = 1;
                }
            }
        }

        // 소수 출력
        System.out.print(show);
        return answer;
    }

    public static void main(String[] args) {
        new Eratosthenes().solution(20);
    }

}
