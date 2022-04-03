package Medium;

public class Q3 extends ListNode{

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null,
                next = null,
                curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return ;
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l2 = reverseLL(slow);

        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
    public static void display(ListNode e) {
        if (e != null) {
            ListNode x = e;
            while (x!=null) {
                System.out.print(x.val + "->");
                x=x.next;
            }
            System.out.println("END");
        }
    }
    public static void main(String[] args) {
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next = new ListNode(5);
//        ll.next.next.next.next.next = new ListNode(6);
        display(ll);
        new Q3().reorderList(ll);
        display(ll);
    }
}
