public class DeleteLeafWithVal {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // we are using postorder because when recursive tree is moving back it will check if the node is
        // leaf if so then condn
        // makes sure that we updates the and check leaf node after we have updated
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null) {
            return root.val == target ? null : root;
        }

        return root;
    }
}
