class Solution(object):
    def mergeKLists(self, lists):
        self.nodes = []
        head=point=ListNode(0)
        for l in lists:
            while l:
                self.nodes.append(l.val)
                l=l.next

        for x in sorted(self.nodes):
            point.next=ListNode(x)
            point=point.next
        return head.next

