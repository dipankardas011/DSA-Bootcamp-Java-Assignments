package Medium;

public class Q10 extends Medium.ListNode{
    public int getSize(ListNode head) {
        if (head == null)
            return 0;
        return 1+getSize(head.next);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int SIZE = getSize(head);
        int numberOfShifts = k % SIZE;
        if (numberOfShifts == 0) {
            return head;
        }
        numberOfShifts = SIZE - numberOfShifts;
        ListNode iter = head;
        int idx = 0;
        ListNode startNode = null;
        ListNode prevStart = null;
        while (iter != null && idx <= numberOfShifts) {
            if (idx == numberOfShifts - 1)
                prevStart = iter;
            startNode = iter;
            idx++;
            iter = iter.next;
        }
        if (prevStart != null)
            prevStart.next = null; // if no replacement is required
        ListNode temp = head;
        head = startNode;

        while (startNode.next != null)
            startNode = startNode.next;
        startNode.next = temp;
        return head;
    }
}
