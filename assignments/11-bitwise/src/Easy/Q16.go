package main

import (
	"fmt"
	"strings"
)

func countConsistentStrings(allowed string, words []string) int {
	count := 0
	for _, word := range words {
		co := 0
		for _, character := range word {
			if strings.Contains(allowed, string(character)) {
				co++
			}
		}
		if co == len(word) {
			count++
		}
	}
	return count
}

func main() {
	fmt.Println(countConsistentStrings("ab", []string{"ad","bd","aaab","baa","badab"}))
	fmt.Println(countConsistentStrings("ab", []string{"ad","bd","aaab","baa","badab"}))
}