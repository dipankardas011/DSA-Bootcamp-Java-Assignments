package main

func uniquePathsWithObstacles(arr [][]int) int {
	if arr[0][0] == 1 {
		return 0
	}
	memory := make([][]int, len(arr))
	for i := range arr {
		memory[i] = make([]int, len(arr[0]))
		// for j:=0; j<len(arr[0]); j++ {
		//     memory[i][j] = -1
		// }
	}
	return evalTabulation(len(arr), len(arr[0]), arr, memory)
	// return eval(len(arr)-1, len(arr[0])-1, arr, memory)
}

func evalTabulation(m, n int, obstacle [][]int, mem [][]int) int {
	for i := 0; i < m; i++ {
		if obstacle[i][0] == 1 {
			break
		}
		mem[i][0] = 1
	}

	for j := 0; j < n; j++ {
		if obstacle[0][j] == 1 {
			break
		}
		mem[0][j] = 1
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if obstacle[i][j] == 1 {
				mem[i][j] = 0
			} else {
				mem[i][j] = mem[i-1][j] + mem[i][j-1]
			}
		}
	}
	return mem[m-1][n-1]
}

func eval(m, n int, obstacle [][]int, mem [][]int) int {
	if m < 0 || n < 0 {
		return 0
	}
	if mem[m][n] != -1 {
		return mem[m][n]
	}

	if m == 0 && n == 0 {
		return 1
	}
	if obstacle[m][n] == 1 {
		return 0
	}
	val := eval(m-1, n, obstacle, mem) + eval(m, n-1, obstacle, mem)
	mem[m][n] = val
	return val
}

func main() {
}
