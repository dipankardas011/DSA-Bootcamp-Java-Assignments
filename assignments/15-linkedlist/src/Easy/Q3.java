package Easy;

import construct.LinkList;

public class Q3 extends LinkList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        ll.push(6);
        ll.display();
        System.out.println(new Q3().middleNode(ll.getHead()).value);
    }
}
