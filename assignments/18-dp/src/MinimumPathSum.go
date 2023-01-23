package main

import "math"

func minPathSum(grid [][]int) int {
	// min := (1 << 31) - 1
	// exec(grid, len(grid)-1, len(grid[0])-1, 0, &min)
	// return min
	return execDP(grid)
}

// func exec(grid [][]int, i, j, currSum int, min *int) {
//     if i < 0 || j < 0 {
//         return
//     }
//     currSum += grid[i][j]
//     if i == 0 && j == 0 {
//         if currSum < *min {
//             *min = currSum
//         }
//         return
//     }
//     if currSum > *min {
//         return
//     }
//     exec(grid, i-1, j, currSum, min)
//     exec(grid, i, j-1, currSum, min)
// }

func execDP(grid [][]int) int {
	for i := 1; i < len(grid); i++ {
		grid[i][0] += grid[i-1][0]
	}

	for j := 1; j < len(grid[0]); j++ {
		grid[0][j] += grid[0][j-1]
	}

	for i := 1; i < len(grid); i++ {
		for j := 1; j < len(grid[0]); j++ {
			grid[i][j] += int(math.Min(float64(grid[i-1][j]), float64(grid[i][j-1])))
		}
	}
	return grid[len(grid)-1][len(grid[0])-1]
}
