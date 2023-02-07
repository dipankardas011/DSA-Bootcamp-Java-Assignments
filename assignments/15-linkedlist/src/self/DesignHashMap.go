package main

import (
	"fmt"
	"hash/fnv"
)

const (
	ARR_LIMIT = 10_000
)

type MyHashMap struct {
	arr [ARR_LIMIT]LinkList
}

//
//  +------+-------+
//  +------+-------+
//    ||
// 	 \ /
//  linklist of each index
//

type LinkList struct {
	Key   int
	Value int
	Next  *LinkList
}

func Constructor() MyHashMap {
	return MyHashMap{arr: [ARR_LIMIT]LinkList{}}
}

func hash(s string) uint32 {
	h := fnv.New32a()
	h.Write([]byte(s))
	return h.Sum32()
}

func (node *LinkList) IsPresent(key int) (*LinkList, error) {
	// till stop when the last element is reached
	for node.Next != nil {
		if key == node.Next.Key {
			return node.Next, nil
		}
		node = node.Next
	}
	return node, fmt.Errorf("Not found")
}

func (this *MyHashMap) Put(key int, value int) {
	index := hash(fmt.Sprint(key)) % ARR_LIMIT
	getHeaderList := this.arr[index]
	if getHeaderList.Next == nil {
		// add here at begining
		getHeaderList.Next = &LinkList{Value: value, Key: key, Next: nil}
		this.arr[index] = getHeaderList
		return
	}
	foundNode, err := getHeaderList.IsPresent(key)

	if err != nil {
		// not found
		foundNode.Next = &LinkList{Value: value, Key: key, Next: nil}
		return
	}
	foundNode.Value = value

}

func Display(this MyHashMap) {
	for i := 0; i < len(this.arr); i++ {
		temp := this.arr[i].Next
		fmt.Println("Index ", i)
		for temp != nil {
			fmt.Println(temp.Key, " ", temp.Value)
			temp = temp.Next
		}
		fmt.Println("<nil>")
	}
}

func (this *MyHashMap) Get(key int) int {

	index := hash(fmt.Sprint(key)) % ARR_LIMIT
	getHeaderList := this.arr[index]
	foundNode, err := getHeaderList.IsPresent(key)
	if err != nil {
		return -1
	}
	return foundNode.Value
}

func (this *MyHashMap) Remove(key int) {

	index := hash(fmt.Sprint(key)) % ARR_LIMIT
	getHeaderList := this.arr[index]
	_, err := getHeaderList.IsPresent(key)
	if err != nil {
		return
	}

	var (
		prev *LinkList
		curr *LinkList
	)
	curr = &this.arr[index]
	prev = nil
	for curr != nil && curr.Key != key {
		prev = curr
		curr = curr.Next
	}
	if prev != nil {
		prev.Next = curr.Next
	} else {
		curr.Next = curr.Next.Next
	}
}

func main() {
	arr := Constructor()
	ptrArr := &arr
	// ptrArr.Put(1, 1)
	// Display(*ptrArr)
	// fmt.Println()
	// ptrArr.Put(1, 2)
	// Display(*ptrArr)
	// fmt.Println()
	// ptrArr.Put(3, 123)
	// Display(*ptrArr)
	// fmt.Println()
	// ptrArr.Put(13, 11223)
	// Display(*ptrArr)

	// fmt.Println(ptrArr.Get(1))
	// fmt.Println(ptrArr.Get(2))
	// fmt.Println(ptrArr.Get(3))
	// fmt.Println(ptrArr.Get(13))

	// ptrArr.Remove(13)
	// Display(*ptrArr)

	ptrArr.Put(1, 1)           // The map is now [[1,1]]
	ptrArr.Put(2, 2)           // The map is now [[1,1], [2,2]]
	fmt.Println(ptrArr.Get(1)) // return 1, The map is now [[1,1], [2,2]]
	fmt.Println(ptrArr.Get(3)) // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
	ptrArr.Put(2, 1)           // The map is now [[1,1], [2,1]] (i.e., update the existing value)
	fmt.Println(ptrArr.Get(2)) // return 1, The map is now [[1,1], [2,1]]
	ptrArr.Remove(2)           // remove the mapping for 2, The map is now [[1,1]]
	fmt.Println(ptrArr.Get(2)) // return -1 (i.e., not found), The map is now [[1,1]]
}
