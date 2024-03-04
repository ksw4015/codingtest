package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 스택, 큐 강의
 * 쇠막대기
 */
public class IronStick {
    private static int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if(s.charAt(i-1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solution(s));
    }
}
