class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class merge2sortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-999);
        ListNode list3 = res;
        ListNode it1 = list1;
        ListNode it2 = list2;

        while (it1 != null && it2 != null) {
            if (it1.val == it2.val) {
                res.next = new ListNode(it1.val);
                res = res.next;
                res.next = new ListNode(it2.val);
                it1 = it1.next;
                it2 = it2.next;
            } else if (it1.val > it2.val) {
                res.next = new ListNode(it2.val);
                it2 = it2.next;
            } else {
                res.next = new ListNode(it1.val);
                it1 = it1.next;
            }
            res = res.next;
        }

        while (it1 != null) {
            res.next = new ListNode(it1.val);
            it1 = it1.next;
            res = res.next;
        }

        while (it2 != null) {
            res.next = new ListNode(it2.val);
            it2 = it2.next;
            res = res.next;
        }

        return list3.next;
    }

    public static void main(String[] args) {
        merge2sortedLists obj = new merge2sortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        ListNode res = obj.mergeTwoLists(l1,l2);
        // print it
    }
}
