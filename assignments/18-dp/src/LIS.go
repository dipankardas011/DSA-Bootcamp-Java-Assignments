package main

import (
	"fmt"
	"math"
)

// lengthOfLIS Longest increasing subsequence
func lengthOfLIS(nums []int) int {
	memory := make([]int, len(nums))
	for i, _ := range nums {
		memory[i] = 1
	}

	ans := 1

	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			// find all the smaller elements than [i]
			if nums[j] < nums[i] {
				memory[i] = int(math.Max(float64(memory[i]), float64(memory[j])+1.0))
				ans = int(math.Max(float64(ans), float64(memory[i])))
			}
		}
	}
	// fmt.Println(memory)
	return ans
}
func main() {
	fmt.Println("vim-go")
}
