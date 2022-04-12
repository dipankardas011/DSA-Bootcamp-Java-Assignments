package Medium;


public class Q5 extends ListNode{
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = null, right = null, iter = head;
        int counter = 0;
        int size = 0;
        while (iter != null) {
            size++;
            iter = iter.next;
        }
        iter = head;
        while (iter != null) {
            if (counter == k-1) {
                left = iter;
            }
            if (counter == size - k) {
                right = iter;
            }
            counter++;
            iter = iter.next;
        }
        int t = left.val;
        left.val = right.val;
        right.val = t;
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
        Q5 o = new Q5();
        o.display(ll);
        ll = o.swapNodes(ll, 2);
        o.display(ll);
    }
}
