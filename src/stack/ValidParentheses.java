package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    /*
        1. 먼저 매핑테이블을 만듬
         - 닫힘 괄호가 Key로 된 Map
        2. 반복문을 실행하면서 열림 괄호인경우 Stack에 Push한다
        3. 닫힘괄호인 경우 Stack에서 pop을한 후 매핑테이블에 있는
           매핑테이블에 있는 닫힘괄호 : 열림괄호 랑 비교한다.
           만약 다른경우 false 리턴
        4. 3의 과정 실행 시 이미 stack이 비어있다면 false 리턴
        5. 반복문 모두 실행 후 stack 사이즈가 0인지 리턴
     */
    public static boolean isValid(String s) {
        Map<Character, Character> mappingTable = new HashMap<>();
        mappingTable.put(')', '(');
        mappingTable.put('}', '{');
        mappingTable.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>(); // {,[
        for(int i = 0 ; i < s.length() ; i++) {
            if(!mappingTable.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if(stack.isEmpty() || mappingTable.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println("" + isValid("()"));
        System.out.println("" + isValid("(){}[]"));
        System.out.println("" + isValid("{[]}"));
        System.out.println("" + isValid("(]"));
    }

}
