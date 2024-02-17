package stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode 316
 *
 * 중복된 문자 제거
 * 중복된 문자가 아니면 제자리 hold
 */
public class RemoveDuplicateLetter {
    public static String removeDuplicateLetters(String s) {
        // 해당 문자가 중복이 있는지 체크
        HashMap<Character, Integer> counter = new HashMap<>();
        // 이미 처리한 문자인지 체크
        HashMap<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray())
           counter.put(c, counter.getOrDefault(c, 0) + 1);
        for(char c : s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);
            // 처리가 끝난 문자는 건너뜀.
            if(seen.get(c) != null && seen.get(c))
                continue;
            // 새로 들어온 문자가 앞으로 이동 해야 되고 (앞에 있는 문자 > 들어온 문자)
            // 자리를 바꿔야 하는 앞에 있는 문자 (peek 한 문자)가 아직 counter에 남아있는 경우 ( > 0)
            // peek을 pop으로 바꿔서 삭제하고, 처리 중인(처리가 끝나지 않은) 상태로 변경
            while(!stack.isEmpty() && stack.peekFirst() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);  // 문자 순서 변경이 일어나는경우 false
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollLast());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
