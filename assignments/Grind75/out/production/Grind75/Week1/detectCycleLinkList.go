package main

type ListNode struct {
    Val int
    Next *ListNode
}

func hasCycle(head *ListNode) bool {
    var slowPtr *ListNode
    var fastPtr *ListNode
    slowPtr = head
    fastPtr = head
    for fastPtr != nil && fastPtr.Next != nil {
        fastPtr = fastPtr.Next.Next
        if fastPtr == slowPtr {
            return true
        }
        slowPtr = slowPtr.Next

    }
    return false
}