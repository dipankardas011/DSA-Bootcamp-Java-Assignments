package construct;

public class LinkList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkList() {
        this.size = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode x) {
        this.head = x;
    }
    public void setTail(ListNode x) {
        this.tail = x;
    }

    protected class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode() {}
    }
    public void pushAtFront(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size ++;
    }
    public void pushAtBack(int val) {
        if (tail == null) {
            tail = head = new ListNode(val);
            return;
        }
        tail.next = new ListNode(val);
        tail = tail.next;
        size++;
    }

    public void push(int val) {
        pushAtBack(val);
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public LinkList copyLinkList(ListNode src) {
        LinkList dest = new LinkList();
        while (src != null) {
            dest.push(src.value);
            src = src.next;
        }
        return dest;
    }

}