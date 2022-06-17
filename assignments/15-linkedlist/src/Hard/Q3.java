package Hard;



public class Q3 {
    private ListNode merged(ListNode l1, ListNode l2) {
        ListNode HH = new ListNode(0);
        ListNode temp = HH;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1=l1.next;
            }
            else {
                temp.next = l2;
                l2=l2.next;
            }
            temp=temp.next;
        }

        while (l1 != null) {
            temp.next = l1;
            l1=l1.next;
            temp=temp.next;
        }

        while (l2 != null) {
            temp.next = l2;
            l2=l2.next;
            temp=temp.next;
        }

        return HH.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0)
            return null;

        ListNode mainR = lists[0];
        for (int i=1; i<lists.length; i++)
            if (lists[i] != null)
                mainR = merged(mainR, lists[i]);
        return mainR;
    }
}
