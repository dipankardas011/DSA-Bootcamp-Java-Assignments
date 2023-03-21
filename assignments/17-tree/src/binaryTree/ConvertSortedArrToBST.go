package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func generateTree(nums []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}
	var mid int = left + (right-left)/2
	temp := &TreeNode{Val: nums[mid]}

	temp.Left = generateTree(nums, left, mid-1) // as the mid elemenet used so mid-1 and mid+1 are taken
	temp.Right = generateTree(nums, mid+1, right)
	return temp
}

func sortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	return generateTree(nums, 0, len(nums)-1)
}

func main() {
	fmt.Println("vim-go")
}
