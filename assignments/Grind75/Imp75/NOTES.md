---
Author: Dipankar Das
Date: 20-8-22
Draft: false
---

Grind 75
---

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
11. 
