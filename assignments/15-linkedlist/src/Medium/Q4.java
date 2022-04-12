package Medium;

public class Q4 extends ListNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        int size = 0;
        ListNode iter = head;
        while (iter != null){
            size++;
            iter = iter.next;
        }

        int position = size - n;
        iter = head;
        ListNode prev = null;
        for (int i = 0; i < position; i++) {
            prev = iter;
            iter = iter.next;
        }
        if (prev != null)
            prev.next = iter.next;
        else
            return head.next;

        return head;
    }

    public void display(ListNode ii) {
        while (ii!=null) {
            System.out.print(ii.val+"->");
            ii = ii.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next = new ListNode(5);
        Q4 o = new Q4();
        o.display(ll);
        ll = o.removeNthFromEnd(ll, 2);
        o.display(ll);
    }
}
