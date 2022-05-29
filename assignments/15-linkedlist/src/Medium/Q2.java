package Medium;


public class Q2 extends ListNode{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode L = head;
        ListNode prevL = null;
        int i = 1;
        while (L != null && i < left) {
            prevL = L;
            L = L.next;
            i++;
        }
        // start to reverse val till we get right
        ListNode prev = prevL;
        ListNode curr = L;
        ListNode next = null;

        while (curr != null && i <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if (prevL == null && curr == null) {
            head = prev;
            return head;
        }
        if (prevL == null && curr != null) {
            head = prev;
            L.next = next;
            return head;
        }
        if (prevL != null && curr == null) {
            // from the starting we are reversing
            prevL.next = prev;
            L.next = null;
            return head;
        }


        prevL.next = prev;
        L.next = curr;
        return head;
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
        display(ll);
//        ListNode xyz1 = new Q2().reverseBetween(ll, 2, 4);
//        display(xyz1);
//        ListNode xyz2 = new Q2().reverseBetween(ll, 1, 4);
//        display(xyz2);
//        ListNode xyz3 = new Q2().reverseBetween(ll, 2, 5);
//        display(xyz3);
        ListNode xyz4 = new Q2().reverseBetween(ll, 1, 5);
        display(xyz4);
    }
}
