package Easy;
import construct.LinkList;

public class Q1 extends LinkList{

    static int position;
    public int Helper_getDecimalValue(ListNode head) {
        if (head == null) {
            position++;
            return 0;
        }

        int prevSum = Helper_getDecimalValue(head.next);
        return prevSum + (head.value)*(1 << (position++));
    }

    static {
        position = -1;
    }

    public int getDecimalValue(ListNode head) {
        return Helper_getDecimalValue(head);
    }


    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.push(1);
        ll.push(1);
        ll.push(1);
        ll.push(1);
        ll.display();
        Q1 o = new Q1();
        System.out.println(o.getDecimalValue(ll.getHead()));
    }
}
