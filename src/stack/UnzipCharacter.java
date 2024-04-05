package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 겹쳐진 압축 해제
 *
 */
public class UnzipCharacter {
    public String solution(String s){
        String answer = "";
        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    String curr = stack.pop();
                    if(curr.charAt(0) == '(') {
                        break;
                    } else {
                        sb.insert(0, curr);
                    }
                }
                int multi = 1;
                if(!stack.isEmpty()) {
                    multi = Integer.parseInt(stack.pop());
                }
                String tmp = "";
                for(int j = 0 ; j < multi ; j++) {
                    tmp += sb.toString();
                }
                stack.push(tmp);
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.removeLast();
        }
        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        Deque<String> st = new ArrayDeque<>();
        for(Character x : s.toCharArray()){
            if(x == ')'){
                String tmp = "";
                while(!st.isEmpty()){
                    String c = st.pop();
                    if(c.equals("(")){  // 닫힘괄호를 만난경우 압축해제 진행
                        String num = "";
                        // 닫힘괄호 이후 문자가 숫자인지 확인
                        while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                            num = st.pop() + num;
                        }
                        String res = "";
                        int cnt; // 압축횟수
                        if(num.equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num);
                        // 압축 해제
                        for(int i = 0; i < cnt; i++)
                            res += tmp;
                        st.push(res);  // 압축해제 완료 후 stack에 넣고 while문 탈출
                        break;
                    }
                    // 닫힘괄호가 아닌경우 문자열 추가
                    tmp = c + tmp;
                }
            }
            else st.push(String.valueOf(x));
        }
        for(String x : st)
            answer += x;
        return answer;
    }


    public static void main(String[] args) {
        UnzipCharacter T = new UnzipCharacter();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution2("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))")); // "ababacacacacacacababacacacacacac
        System.out.println(T.solution("3(ab2(sg))"));  // absgsgabsgsgabsgsg
    }
}
