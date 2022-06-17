package Hard;

public class Q1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode HH = new ListNode(-111, head);
        ListNode iter = HH.next;
        ListNode PREV = HH;

        while (iter != null) {

            ListNode curr = iter, prev = PREV, next = iter;
            // not update if the rem size is < k

            if (!remcheckIt(iter, k)) {
                return HH.next;
            }

            for (int i=1; i<=k && curr != null; i++) {
                next = next.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            iter.next = next;
            PREV.next = prev;
            PREV = iter;
            iter = next;
        }
        return HH.next;
    }

    private boolean remcheckIt(ListNode iter, int k) {
        ListNode x = iter;
        for (int i=1; i<=k;i++) {
            if (x==null)
                return false;
            x=x.next;
        }
        return true;
    }

    public void display(ListNode x) {
        ListNode y = x;
        while (y != null) {

            System.out.print(y.val+"->");

            y=y.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next = new ListNode(5);
//        ll.next.next.next.next.next = new ListNode(6);
        Q1 o = new Q1();
        o.display(ll);
        ListNode res = o.reverseKGroup(ll,3);
        o.display(res);
    }
}
