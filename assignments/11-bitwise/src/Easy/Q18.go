package main

import "fmt"

func subsetXORSum(nums []int) int {
	subSet := make([][]int, 1)

	for i := 0; i < len(nums); i++ {
		len := len(subSet)
		for j := 0; j < len; j++ {
			xx := make([]int, 0)
			xx = append(xx, subSet[j]...)
			xx = append(xx, nums[i])
			subSet = append(subSet, xx)
		}
	}

	//fmt.Println(subSet)
	sum := 0
	for _, arr := range subSet {
		xor := 0
		for i := 0; i < len(arr); i++ {
			xor ^= arr[i]
		}
		sum += xor
	}

	return sum
}

func main() {
	fmt.Println(subsetXORSum([]int{5,1,6}))
}