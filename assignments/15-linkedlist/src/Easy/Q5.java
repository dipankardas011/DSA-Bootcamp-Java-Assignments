package Easy;

import construct.LinkList;

public class Q5 extends LinkList {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
