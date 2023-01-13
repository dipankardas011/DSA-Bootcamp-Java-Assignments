public class q3 {
    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == right && left == null ) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            boolean res1 = isSame(left.right, right.left);
            boolean res2 = isSame(left.left, right.right);
            return !res1 || !res2 ? false : true;
        } else {
            return false;
        }
    }

    /**
     * @def it returns true of the left subtree is mirror image of right subtree
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSame(root.left, root.right);
    }
}
