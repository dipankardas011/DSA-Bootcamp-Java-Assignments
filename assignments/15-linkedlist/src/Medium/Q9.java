package Medium;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int x) {
        this.val = x;
        this.next = null;
    }
};

public class Q9 {
    public Node flatten(Node head) {
        Node iter = head;
        while (iter != null) {
            if (iter.child == null ) {
                iter = iter.next;
            } else {
                Node iii = iter.child;
                iter.child = null;
                Node tt = iter.next;
                iter.next = iii;
                iii.prev = iter;
                while (iii.next != null) {
                    iii = iii.next;
                }

                iii.next = tt;
                if (tt != null)
                    tt.prev = iii;
            }
        }
        return head;
    }

    public static void main(String[] args) {}
}
