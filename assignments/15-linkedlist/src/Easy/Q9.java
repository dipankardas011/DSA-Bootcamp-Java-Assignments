package Easy;

import construct.LinkList;

public class Q9 extends LinkList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.value == list.next.value) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }
}
