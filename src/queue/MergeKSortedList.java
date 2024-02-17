package queue;

import linkedlist.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val == o2.val)
                    return 0;
                else if(o1.val > o2.val)
                    return 1;
                else
                    return -1;
            }
        });

        for(ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode root = new ListNode(0);
        ListNode tail = root;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();  // val = 0, node = 1,4,5
            tail = tail.next; // val = 1, node = 4,5
            if(tail.next != null) { // val = 4, node = 5
                pq.add(tail.next);
            }
        }
        return root.next;
    }

    public static void main(String[] args) {

    }
}
