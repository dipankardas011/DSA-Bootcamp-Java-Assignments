package Medium;

public class Q17 {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head;
        while(curr!=null){
            if(curr!=null && curr.next!=null){
                int temp = curr.val;
                curr.val = curr.next.val;
                curr.next.val = temp;
                curr = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
