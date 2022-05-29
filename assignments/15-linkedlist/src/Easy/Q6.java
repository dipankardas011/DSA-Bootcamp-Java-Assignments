package Easy;

import construct.LinkList;

public class Q6 extends LinkList {
    private static ListNode NODE;

    private boolean isPalinUtil(ListNode head, ListNode tail)
    {
        if (tail == null) {
            NODE = head;
            return true;
        }

        boolean res = isPalinUtil(head, tail.next);

        // NODE = head;

        if (!res)
            return false;

        // System.out.println(NODE.val + " ?= " + tail.val);

        if (NODE.value != tail.value)
            return false;

        NODE = NODE.next;

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        boolean res = isPalinUtil(head, head);
        // System.out.println();
        return res;
    }

    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(1);
        ll.display();
        System.out.println(new Q6().isPalindrome(ll.getHead()));
    }
}
