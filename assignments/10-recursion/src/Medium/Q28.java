package Medium;

class Linklist {

    public Node root;

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    public Linklist() {
        this.root = null;
    }

    void create() {
        this.root = new Node(1);
        this.root.left = new Node(2);
        this.root.right = new Node(3);
    }

    private void inorderTrav(Node root) {
        if (root != null) {
            inorderTrav(root.left);
            System.out.print(root.data + " ");
            inorderTrav(root.right);
        }
    }

    private Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        else if (left == null)
            return right;
        else
            return left;
    }

    public void getLCA() {
        Node kk = lca(this.root, 2,3);
        if (kk == null)
            System.out.println("-1");
        else
            System.out.println(kk.data);
    }

    public void display() {
        inorderTrav(this.root);
        System.out.println();
    }
}

public class Q28 extends Linklist{

    public Q28() {
        super();
    }

    public static void main(String[] args) {
        Q28 list = new Q28();
        list.create();
        list.display();
        list.getLCA();
    }
}