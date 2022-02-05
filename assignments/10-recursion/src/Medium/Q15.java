package Medium;


class Node {
    public int num;
    public Node next;
    public Node prev;

    public Node(int n) {
        this.num=n;
        this.prev = null;
        this.next = null;
    }

    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}



public class Q15 {

    public int findTheWinner(int n, int k) {
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n ; i++) {
            Node curr = new Node(i);
            curr.prev = prev;
            prev.next = curr;
            prev = curr;
        }
        prev.next = head;
        head.prev = prev;

//        setuped
        Node temp = head;
        while (temp != temp.next) {
            for (int i = 1; i < k; i++) {
                temp = temp.next;
            }
            temp.remove();
            temp = temp.next;
        }
        return temp.num;
    }

    public static void main(String[] args) {
        Q15 o = new Q15();
        System.out.println(o.findTheWinner(5,2));
        System.out.println(o.findTheWinner(6,5));
    }
}