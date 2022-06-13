package Medium;

public class Q13 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;

        ListNode myHead = new ListNode(0, head);
        ListNode newHH = myHead;

        while (iter != null) {
            if (iter.next != null && iter.val == iter.next.val) {
                while (iter.next != null && iter.val == iter.next.val) {
                    iter = iter.next;
                }

                myHead.next = iter.next;
            } else {
                myHead = myHead.next;
            }
            iter = iter.next;
        }

        return newHH.next;
    }
}
