---
Author: Dipankar Das
Date: 20-8-22
Draft: false
---

# Extra

1. RobHouse (**MEDIUM**) as we see adjacent house cannot be robed so i-2 and i can be robbed so build a recursive then DP + mem
2. zigzagLevelOrder (**Medium**) Extract the all nodes with their level labled and then extra elements based on their level and store them in list<>
3. 

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
5. MajorityElement (**EASY**) use the Boyer–Moore majority vote algorithm
6. DiameterBinaryTree (**MEDIUM**) as its distance (longest) so used the depth of left and right AND SUM it to get the max 
and return the depth to the recursion Tree
7. AddBinary (**EASY**)
8. MiddleOfLinklist (**EASY**) we can use the O(n/2) to get the middle element using the slow and fasst pointer
9. MaxiumDepthOfBinaryTree (**EASY**) to calculate the depth of each node and send the max(depth(left), depth(right))
10. ContainsDeuplicates (**EASY**) use the hasMap to get the freq if the element is already present then return true
11. MaxiumSubarray (**MEDIUM**) if the current sum becomes < 0 then reset to 0 and again start accumulate()

## Week 3

1. InsertInterval (**MEDIUM**) :warning: `some magic algo`
    > There shouldn't be overlap
2. 01Matrix(**MEDIUM**) Dynamic programming `TODO`
3. KClosestPointToOrigin (**MEDIUM**) as we need to calculate the distance of all points after its done we need to retrieve the smallest elements for k number of times (Min Heap)
4. LongestSubstringNoDuplicates (**MEDIUM**) key is to keep track of length if the item is present then use the stored index of that item  + 1 and get max and update the start index of substring
    basically updating the start index of substring when ever ele is present
5. 3Sum (**MEDIUM**) Store the elements as key and indexes as value get the pair of i,j and search target in hashMap 
where the target index if found should be > i and > j to be added in resultant list then update the j
6. LevelOrder (**MEDIUM**) Use the Queue to store the elements with their level info and when printing same level will be made into a new list and then appended to the resultant list
7. CloneGraph (**MEDIUM**) As we need to copy the graph we need to get all the children and copy all this depth so
like bfs used for each child we used that child to create New Node() and add it to copy node in a Recursion Tree
if found use a method store the already created nodes with given node.val as its distinct
8. EvaluateReversePolishNotation (**MEDIUM**) As its Postfix left -> right so we can use stack to store and when operator comes pop2() () pop1()

## Week 4

1. CourseSchedule (**MEDIUM**) as its mention about dependencies and there should be no dependencies such that cycle forms so we need to check for dependencies for cycle detection i.e. about the nnumber of indegrees if we are in `u -> v` then if indegree(v) == 1 it means that v dependent on onlly 1 that is u , also the indegree helps us to get the number of dependencies for that vertex left if after going though all the vertex there is still some vertex with non zero indegree it means there was cycle so all courses cannot be scheduled
2. Trie (**MEDIUM**) trie is used for prefix matching 
3. Coin Change (**MEDIUM**) as everytime we need to get the min steps among the all the coins so we can memorize to reduce the number of repetation of computation
4. ProductArrayExceptSelf (**MEDIUM**) key is to make the last and first as 1 then go on multiplying the as nirmal left to right
5. 
