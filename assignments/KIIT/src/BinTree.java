import java.util.ArrayDeque;
import java.util.Queue;

class BinaryTree {
    private int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
        left = right = null;
    }

    public void inorderTrav(BinaryTree root) {
        if (root != null) {
            inorderTrav(root.left);
            System.out.print(root.data + " ");
            inorderTrav(root.right);
        }
    }

    public void levelOrderTrav(BinaryTree root) {
        Queue<BinaryTree> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            BinaryTree level = que.poll();
            System.out.print(level.data + " ");
            if (level.left != null)
                que.add(level.left);
            if (level.right != null)
                que.add(level.right);
        }
    }
}

public class BinTree {
    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   3
         *  / \   /
         * 4  5  6
         *  \
         *   7
         *  / \
         *  9 10
         */

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(9);
        root.left.left.right.right = new BinaryTree(10);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.inorderTrav(root);
        System.out.println();
        root.levelOrderTrav(root);
        System.out.println();
    }
}
