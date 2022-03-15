package main

import "fmt"

func numberOfSteps(num int) int {
	if num > 0 {
		if (num & 1) == 1 {
			return 1 + numberOfSteps(num - 1)
		} else {
			return 1 + numberOfSteps(num >> 1)
		}
	} else {
		return 0
	}
}

func main() {
	fmt.Println(numberOfSteps(6))
}
