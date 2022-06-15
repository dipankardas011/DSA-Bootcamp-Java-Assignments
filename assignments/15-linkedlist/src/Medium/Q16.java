package Medium;

class Node16 {
    int key;
    Node16 next;
}

public class Q16 {
    /**
     * In this method, a temporary node is created.
     * The next pointer of each node that is traversed is made to point to this temporary node.
     * This way we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not.
     * Every node is checked to see if the next is pointing to a temporary node or not.
     * In the case of the first node of the loop, the second time we traverse it this condition will be true, hence we return that node.
     */
    Node16 firstNodeLoop(Node16 head) {
        Node16 temp = new Node16();

        while (head != null) {
            if (head.next == null)
                return null;
            if (head.next == temp)
                // its already there
                return head;

            Node16 tt = head.next;

            head.next = temp;

            head = tt;
        }
        return null;
    }
}
