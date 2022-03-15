package main

import "fmt"

func countPrimeSetBits(left int, right int) int {
    count := 0
    for i := left; i <= right; i++ {
        vv := 0
        n := i
        for n > 0 {
            if (n&1) == 1 {
                vv++
            }
            n >>= 1
        }
        if isPrime(vv) {
            count++
        }
    }
    return count
}

func isPrime(noOfSetBits int) bool {
    switch noOfSetBits {
        case 2, 3, 5, 7, 11, 13, 17, 19: return true
        default: return false
    }
}

func main() {
    fmt.Println(countPrimeSetBits(6, 10))
}