package linkedlist;

import linkedlist.model.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev= null;
        ListNode curr = head;
        // 기존 주어진 노드 정방향 순회
        while (curr != null) {
            // 마지막에 순회를 위해 옆으로 이동해야 하니, 미리 next 값을 빼둔다
            ListNode next = curr.next;
            // 현재 노드의 옆을 이전 노드로 지정
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
