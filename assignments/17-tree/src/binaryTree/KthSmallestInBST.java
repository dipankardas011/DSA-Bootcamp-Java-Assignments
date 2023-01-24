import com.sun.source.tree.Tree;

import java.util.Stack;

//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode() {}
//  TreeNode(int val) { this.val = val; }
//  TreeNode(int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//  }
//}
public class KthSmallestInBST {

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stk = new Stack<>();
		TreeNode iter = root;
		while (iter!=null) {
			stk.add(iter);
			iter = iter.left;
		}
		while (k != 0) {
			TreeNode temp = stk.pop();
			k--;
			if (k == 0) {
				return temp.val;
			}
			if (temp.right != null) {
				temp = temp.right;
//				stk.push(temp);
				while (temp != null) {
					stk.add(temp);
					temp = temp.left;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {

	}
}