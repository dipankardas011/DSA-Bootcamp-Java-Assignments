import java.util.*;

public class LevelOrder2 {

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);

        List<Integer> level = new ArrayList<>();
        int prevLevel = getDepth(root);
        while (!levels.isEmpty()) {
            TreeNode node = levels.poll();
            System.out.println(node.val + " ");
//            if (node == )
//            if (getDepth(node) == prevLevel) {
//                level.add(node.val);
//            } else {
//                levelOrder.add(level);
//                prevLevel = getDepth(node);
//                level = new ArrayList<>();
//                level.add(node.val);
//            }
            if (node.left != null)
                levels.add(node.left);
            if (node.right != null)
                levels.add(node.right);
        }
//        for (List i : levelOrder) {
//            System.out.println(Arrays.toString(i.toArray()));
//        }
        return levelOrder;
    }
}
