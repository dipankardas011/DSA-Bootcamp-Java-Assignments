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