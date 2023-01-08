public class q2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            boolean resLeft = isSameTree(p.left, q.left);
            boolean resRight = isSameTree(p.right, q.right);
            return !resLeft || !resRight ? false : true;
        } else {
            return false;
        }
    }
}
