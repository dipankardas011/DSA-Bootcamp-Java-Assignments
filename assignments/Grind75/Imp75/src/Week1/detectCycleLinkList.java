package Week1;//class ListNode {
//    int val;
//    ListNode next;
//    public ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}

public class detectCycleLinkList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}