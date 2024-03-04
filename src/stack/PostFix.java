package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostFix {
    private static int solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(Integer.valueOf(String.valueOf(c)));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(b+a);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '*':
                        stack.push(b*a);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                }
            }
        }
        if(stack.isEmpty())
            return 0;
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.print(solution("352+*9-"));
    }
}
