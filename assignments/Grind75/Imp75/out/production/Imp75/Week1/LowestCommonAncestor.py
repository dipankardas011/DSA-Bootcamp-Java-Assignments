class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(self, root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(self, root.left, p, q)
        else:
            return root
