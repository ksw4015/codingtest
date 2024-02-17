package linkedlist;

import linkedlist.model.ListNode;

public class MergeTwoList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // create a dummy node
        ListNode curr = dummy;
        while(list1!=null && list2!=null){ //Merge List
            if(list1.val <= list2.val) {  // add the next pointer of temp to the smallest value after comparing both lists
                curr.next = list1;  // 작은값 삽입
                list1=list1.next;  // 삽입 후 오른쪽으로 이동
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr= curr.next;  // 최초 val은 더미값이니 뒤에값으로 변경?
        }
        if(list1 != null){  // if any one list is still remaining then point our temp.next pointer to it, so all the values ahead of the list will also be automatically attached.
            curr.next= list1;
        }else{
            curr.next= list2;
        }
        return dummy.next; // as temp was pointing to ans first then followed by rest of two lists, we can return ans.next which will give the start position(head) of the temp.
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merge = mergeTwoLists(node1, node2);
        while (merge != null) {
            System.out.println("" + merge.val);
            merge = merge.next;
        }
    }
}
