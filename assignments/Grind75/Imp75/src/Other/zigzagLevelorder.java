package Other;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class zigzagLevelorder {
    class Type {
        public TreeNode node;
        public int level;
        public Type(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
        @Override
        public String toString() {
            return this.node.val + " " + this.level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Type> que = new LinkedList<>();
        List<Type> temp = new ArrayList<>();

        int prevLevel = 0;
        que.add(new Type(root, 0));
        while (!que.isEmpty()) {
            Type type = que.remove();
            temp.add(type);

            if (type.node.left != null)
                que.add(new Type(type.node.left, type.level+1));
            if (type.node.right != null)
                que.add(new Type(type.node.right, type.level+1));
        }
        for (Type ele : temp) {
            System.out.print(" ["+ele+"]");
        }

        List<Integer> abcd = new ArrayList<>();
        int prev = 0;
        for (Type type : temp) {
            if (prev == type.level) {
                abcd.add(type.node.val);
            } else {
                if ((prev % 2) != 0)
                    Collections.reverse(abcd);
                res.add(abcd);
                prev = type.level;
                abcd = new ArrayList<>();
                abcd.add(type.node.val);
            }
        }
        if ((prev % 2) != 0)
            Collections.reverse(abcd);
        res.add(abcd);
        return res;
    }
}
