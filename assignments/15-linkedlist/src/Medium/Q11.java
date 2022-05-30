package Medium;

import java.util.HashMap;

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Q11 extends Node1 {
    public Q11(int val) {
        super(val);
    }

    public Node1 copyRandomList(Node1 head) {
        HashMap<Node1, Node1> hsMap = new HashMap<>();
        Node1 newHead = null;

        Node1 iter = head;
        while (iter != null ) {
            Node1 newN = new Node1(iter.val);
            newN.next = null;
            newN.random = iter.random;
            if (newHead == null) {
                newHead = newN;
            } else {
                Node1 tt = newHead;
                while (tt.next != null) tt = tt.next;
                tt.next = newN;
            }
            hsMap.put(iter, newN);
            iter = iter.next;
        }

        iter = newHead;
        while (iter != null) {
            if (iter.random != null ) {
                // change the value
                iter.random = hsMap.get(iter.random);
            }
            iter=iter.next;
        }
        return newHead;
    }
}
