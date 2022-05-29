package Easy;

import construct.LinkList;

public class Q2 extends LinkList {

    /**
     * @Bug param {@tail} is not updated as the question does not demand
     * @param head
     * @return
     */
    LinkList.ListNode he = null;
    public void reverseList(ListNode head) {
        setTail(head);
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head;
        while (curr != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        setHead(prev);
//        return head;
        he = prev;
    }

    public static void main(String[] args) {
        construct.LinkList ll = new construct.LinkList();
        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        ll.display();
        Q2 o = new Q2();
        o.reverseList(ll.getHead());
        ll = ll.copyLinkList(o.he);
        ll.display();
    }


}
