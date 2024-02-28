package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 스택, 큐 강의
 * 괄호안의 문자를 제거하고 남은 문자들을 순서대로 한 줄에 출력
 */
public class RemoveInBracket {
    /*
         In : (A(BC)D)EF(G(H)(IJ)K)LM(N)
         Out : EFLM
     */
    private static void solution(String s) {
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(stack.isEmpty()) {
                sb.append(s.charAt(i));
            } else if(mapping.containsKey(s.charAt(i))){
                stack.pop();
            }
        }
        System.out.print(sb.toString());
    }

    private static void solution2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c == ')') {
                while (stack.pop() != '(') {}
            } else {
                stack.push(c);
            }
        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer += stack.pollLast();
        }
        System.out.print(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution2(sc.nextLine());
    }
}
