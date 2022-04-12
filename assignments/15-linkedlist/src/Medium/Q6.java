package Medium;

public class Q6 extends ListNode{

    private int sizeFinder(ListNode node) {
        if (node == null)
            return 0;
        return 1 + sizeFinder(node.next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // which one is the largest one
        if (sizeFinder(l1) < sizeFinder(l2))
            return addTwoNumbers(l2, l1);
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        int carry = 0;
        ListNode prev = iter1;

        while (iter1 != null && iter2 != null) {
            int sum = (iter1.val + iter2.val + carry);
            carry = sum / 10;
            sum %= 10;
            iter1.val = sum;
            prev = iter1;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        while (iter1 != null) {
            int sum = (iter1.val + carry);
            carry = sum / 10;
            sum %= 10;
            iter1.val = sum;
            prev = iter1;
            iter1 = iter1.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return l1;
    }


    public void display(ListNode ii) {
        while (ii!=null) {
            System.out.print(ii.val+"->");
            ii = ii.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        ListNode ll = new ListNode(2);
        ll.next = new ListNode(4);
        ll.next.next = new ListNode(3);

        ListNode ll1 = new ListNode(5);
        ll1.next = new ListNode(6);
        ll1.next.next = new ListNode(4);

        Q6 o = new Q6();
        o.display(ll);
        o.display(ll1);

        ll = o.addTwoNumbers(ll, ll1);
        o.display(ll);
    }
}
