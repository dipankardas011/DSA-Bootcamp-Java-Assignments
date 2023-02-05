package main

import (
	"fmt"
	"math"
)

func maxArea(height []int) int {
	left := 0
	right := len(height) - 1
	area := math.MinInt
	for left < right {
		w := right - left
		h := int(math.Min(float64(height[left]), float64(height[right])))
		if area < w*h {
			area = w * h
		}
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return area
}
func main() {
	bars := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	fmt.Println(maxArea(bars))
}
