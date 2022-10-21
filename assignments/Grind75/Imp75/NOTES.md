---
Author: Dipankar Das
Date: 20-8-22
Draft: false
---

# Grind 75

## Week 1

1. TwoSum (**EASY**) Used HasMap for storing the current <element,index> when target-this_no not found
2. ValidParenthesis (**EASY**) USed Stack to keep track of the brackets visited and used balance variable
3. merge2SortedLists (**EASY**) as it's given in sorted list, and we have to merge it; use the merge procedure
4. BestTimetoBuyandSellStock (**EASY**) as loop inside loop will have N^2 so to get max from the remaning elements in right in O(1)
            we store the max elements from right to left in another array when the element is and maxEle from that index in maxEleme Array is the answer
5. ValidPalindrome (**EASY**) filter the noise from the string and then check palindrome using left and right pointers
6. InvertBinaryTree (**EASY**) as it is a subproblem it can be solved using recustion just exchange the pointers
7. ValidAnagram (**EASY**) as we need to make all the character in s must be used in t so freq of all charcater must be same
8. BinarySearch (**EASY**) the array is sorted and we can divide the array to find the elements in smallest subset of the array using the property of sorted array
9. FloodFill (**MEDIUM**) as we need the traverse in 4 directions and check whether its same as org color backtracking and recusion
10. BalancedBinaryTree (**EASY**) calculate height at each node and find it's `abs() for left and right <= 1` if root != nil then return true
11. DetectCycleLinkList (**EASY**) Using slow and fast pointer as when it collides there is cycle
12. QueueUsingStack (**EASY**) top of stack is front of queue

## Week 2

1. FirstBadVersion(**EASY**) as versions are already sorted in increasing order to binary search will work if found bad move to left if not bad your goal is on right
2. Ransom Note (**EASY**) as we can determine it using counter of characters if not present in word store then not possible and if no of word store is less than req to create the word the also fails
3. Climbing Stairs (**EASY**) found that internally fabonacci number is used as no repeatation is allowed
4. LongestPalindrome (**EASY**) if the count of character is multiple of 2 then its possible to add it to the result
5. 