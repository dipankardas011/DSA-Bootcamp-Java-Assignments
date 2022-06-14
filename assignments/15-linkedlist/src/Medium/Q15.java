package Medium;

public class Q15 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0, head);
        ListNode right = new ListNode(0, null);
        ListNode headR = right, headL = left;

        while (head != null) {

            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = headR.next;
        right.next = null;

        head = headL.next;
        return head;
    }
}
