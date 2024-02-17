package linkedlist;

import linkedlist.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        // 스택을 이용한 팰린드롭 판단
        // 스택은 선입후출이라 먼저 삽입후 pop하면서 비교
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        while (head != null) {
            if(stack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeDeque(ListNode head) {
        ListNode node = head;
        Deque<Integer> deque = new LinkedList<>();
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }
        while (!deque.isEmpty() && deque.size() > 1) {
            if(deque.pollFirst() != deque.pollLast())
                return false;
        }
        return true;
    }

    public static boolean isPalindromeRunner(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // 2칸식
            slow = slow.next;  // 1칸식
        }
        if(fast != null) {
            slow = slow.next;  // 리스트가 홀수인 경우 slow는 한칸더 이동해서 중앙값
        }
        ListNode rev = null;
        // 역순으로 만들기
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }
        while (rev != null) {
            if(rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("" + isPalindrome(head));
        System.out.println("" + isPalindromeDeque(head));
        System.out.println("" + isPalindromeRunner(head));
    }

}


