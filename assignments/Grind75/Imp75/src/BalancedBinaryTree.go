package main

import(
	"math"
	"fmt"
)


type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
    if root != nil {
        if int64(math.Abs(getHeight(root.Left) - getHeight(root.Right))) <= 1 {
            return isBalanced(root.Left) && isBalanced(root.Right)
        } else {
            return false
        }
    } else {
        return true
    }
}

func getHeight(root *TreeNode) float64 {
    if root != nil {
        return 1.0 + math.Max(getHeight(root.Left), getHeight(root.Right))
    }else {
        return 0.0
    }
}

func main() {
	fmt.Println("SUCCESS!")
}
