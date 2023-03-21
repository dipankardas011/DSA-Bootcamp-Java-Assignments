package main

import "fmt"

type Set struct {
	Parent       []int
	NoOfElements int
	Rank         []int
}

type SetOperation interface {
	findSet(int) int
	unionSet(int, int)
	initialize()
}

func (set *Set) initialize() {
	set.Parent = make([]int, set.NoOfElements)
	set.Rank = make([]int, set.NoOfElements)
	for i := 0; i < set.NoOfElements; i++ {
		set.Parent[i] = -1
		set.Rank[i] = 1
	}
}

func (set *Set) findSet(item int) int {

	for set.Parent[item] > 0 {
		item = set.Parent[item]
	}

	return item
}

func (set *Set) unionSet(set1, set2 int) {
	setX := set.findSet(set1)
	setY := set.findSet(set2)
	if set.Rank[setX] > set.Rank[setY] && setX != setY {
		set.Parent[setY] = setX
		set.Rank[setX] += set.Rank[setY]
		return
	}

	if set.Rank[setX] <= set.Rank[setY] && setX != setY {
		set.Parent[setX] = setY
		set.Rank[setY] += set.Rank[setX]
	}
}

func validPath(n int, edges [][]int, source int, destination int) bool {

	var set SetOperation = &Set{NoOfElements: n}
	set.initialize()

	for _, edge := range edges {
		set.unionSet(edge[0], edge[1])
	}

	// if the intersection is NULL set then they are discontinuous so no path can exists
	return set.findSet(source) == set.findSet(destination)
}

func main() {
	fmt.Println(validPath(3, [][]int{
		{0, 1},
		{1, 2},
		{2, 0}},
		0,
		2))
}
