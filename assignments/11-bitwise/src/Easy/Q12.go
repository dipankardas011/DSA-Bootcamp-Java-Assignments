package main

import (
	"fmt"
	"math"
)

func checkBitMap(n int, i int) {
	if  i < 32 {
		checkBitMap(n, i+1)
		fmt.Printf("%v",(n>>i)&1)
	}
}

func binaryGap(n int) int {

	counter := 0
	lastIdx := -1

	checkBitMap(n, 0)
	fmt.Println()

	for i := 0; i < 32; i++ {
		if (n >> i) & 1 == 1 {
			if lastIdx >= 0 {
				counter = int(math.Max(float64(counter), float64(i-lastIdx)))
			}
			lastIdx = i
		}
	}
	return counter
}

func main() {
	fmt.Println(binaryGap(6))
	fmt.Println(binaryGap(22))
	fmt.Println(binaryGap(8))
	fmt.Println(binaryGap(5))
}
