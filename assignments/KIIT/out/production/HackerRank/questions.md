# Questions from KIIT


1. Find a pair with a minimum absolute sum in an array.(**DONE**)
  Given a sorted integer array, find a pair in it having an absolute minimum sum.
For example,
Input:  A = [-6, -5, -3, 0, 2, 4, 9]
Output: Pair is (-5, 4)
(-5, 4) = abs(-5 + 4) = abs(-1) = 1, which is minimum among all pairs.

2. Maximum Sum Subarray Problem (Kadane’s Algorithm)
Given an integer array, find a contiguous subarray within it that has the largest sum.
For example,
Input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
Output: Subarray with the largest sum is {4, -1, 2, 1} with sum 6.

3. Count decodings of a given sequence of digits:
   Given a positive number, map its digits to the corresponding alphabet in the mapping table [(1, 'A'), (2, 'B'), … (26, 'Z')], and return the count of the total number of decodings possible. Assume that the input number can be split into valid single-digit or two-digit numbers that are present in the mapping table.
For example,
Input:  123
Output: 3
The possible decodings are [ABC, AW, LC]
Input:  1221
Output: 5
The possible decodings are [ABBA, ABU, AVA, LBA, LU]

4. Inversion count of an array:
   Given an array, find the total number of inversions of it. If (i < j) and (A[i] > A[j]), then pair (i, j) is called an inversion of an array A. We need to count all such pairs in the array.

For example,

Input:  A[] = [1, 9, 6, 4, 5]

Output: The inversion count is 5

There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)

5. Partition an array into two subarrays with the same sum

Given an integer array, partition it into two subarrays having the same sum of elements.

For example,

Input:  {6, -4, -3, 2, 3}

Output: The two subarrays are {6, -4} and {-3, 2, 3} having equal sum of 2

Input:  {6, -5, 2, -4, 1}

Output: The two subarrays are {} and {6, -5, 2, -4, 1} having equal sum of 0

6. Given a string that (may) be appended with a number at last. You need to find whether the length of string excluding that number is equal to that number. For example for “helloworld10”, answer is True as helloworld consist of 10 letters. Length of String is less than 10, 000.

Examples :

Input:  str = "hello5"
Output:  Yes
Explanation : As hello is of 5 length and at last number is also 5.

Input:  str = "kiituniversity15"
Output:  No
Explanation: As kiituniversity is of 14 length and at last number is 15


7. Given an array of elements and change the array in such a way that all the elements on the array are distinct. if you are replacing a value, then the replacing value should be great than the previous value and after modification sum of the elements should be as less as possible.
   Example: arr[1, 2, 3, 4, 5, 5, 5] and the result should be [1, 2, 3, 4, 5, 6, 7]
   example 2 [1, 2, 5, 7, 8, 8, 7] then the result should be [1, 2, 5, 7, 8, 9, 10] or 1, 2, 5, 7, 8, 10,

8. Find the maximum sum of a subsequence with no adjacent elements

Given an integer array, find the maximum sum of subsequence where the subsequence contains no element at adjacent positions.

Please note that the problem specifically targets subsequences that need not be contiguous, i.e., subsequences are not required to occupy consecutive positions within the original sequences.

For example,

Input:  { 1, 2, 9, 4, 5, 0, 4, 11, 6 }
Output: The maximum sum is 26

The maximum sum is formed by subsequence { 1, 9, 5, 11 }

9. Longest Bitonic Subarray Problem

The Longest Bitonic Subarray (LBS) problem is to find a subarray of a given sequence in which the subarray’s elements are first sorted in increasing order, then in decreasing order, and the subarray is as long as possible. Strictly ascending or descending subarrays are also accepted.

For example,

Longest bitonic subarray of the sequence { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 } is { 4, 5, 9, 10, 8, 5, 3 }

For sequences sorted in increasing or decreasing order, the output is the same as the input sequence, i.e.,

[1, 2, 3, 4, 5] ——> [1, 2, 3, 4, 5]
[5, 4, 3, 2, 1] ——> [5, 4, 3, 2, 1]

10. Find duplicates within a range k in an array

Given an array and a positive number k, check whether the array contains any duplicate elements within the range k. If k is more than the array’s size, the solution should check for duplicates in the complete array.

For example,

Input:

nums[] = { 5, 6, 8, 2, 4, 6, 9 }
k = 4

Output: Duplicates found

(element 6 repeats at distance 4 which is <= k)

Input:

nums[] = { 5, 6, 8, 2, 4, 6, 9 }
k = 2

Output: No duplicates were found

(element 6 repeats at distance 4 which is > k)

Input:

nums[] = { 1, 2, 3, 2, 1 }
k = 7

Output: Duplicates found

(element 1 and 2 repeats at distance 4 and 2, respectively which are both <= k)

11. Find minimum product among all combinations of triplets in an array

Given an integer array, find the minimum product among all combinations of triplets in the array.

For example,

Input:  { 4, -1, 3, 5, 9 }
Output: The minimum product is -45 (-1, 5, 9)

Input:  { 1, 4, 10, -2, 4 }
Output: The minimum product is -80 (10, 4, -2)

Input:  { 3, 4, 1, 2, 5 }
Output: The minimum product is 6 (3, 1, 2)

12. Print all triplets that form an arithmetic progression

Given a sorted array of distinct positive integers, print all triplets that forms an arithmetic progression with an integral common difference.

An arithmetic progression is a sequence of numbers such that the difference between the consecutive terms is constant. For instance, sequence 5, 7, 9, 11, 13, 15, … is an arithmetic progression with a common difference of 2

For example,

Input:  A[] = { 5, 8, 9, 11, 12, 15 }

Output:
5 8 11
9 12 15

Input:  A[] = { 1, 3, 5, 6, 8, 9, 15 }

Output:
1 3 5
1 5 9
3 6 9
1 8 15
3 9 15

13. Find the minimum number of squares that sum to a given number

Given a positive integer n, find the minimum number of squares that sums to n.

For example,

Input: 100
Output: 1
100 is a perfect square. It can be represented as 10^2.

Input: 10
Output: 2
10 can be represented as 3^2 + 1^2.

Input: 63
Output: 4
63 can be represented as 7^2 + 3^2 + 2^2 + 1^2.

14. Find the missing number and duplicate elements in an array

Given an integer array of size n, with all its elements between 1 and n and one element occurring twice and one element missing. Find the missing number and the duplicate element in linear time and without using any extra memory.

For example,

Input:  arr[] = [4, 3, 6, 5, 2, 4]

Output: The duplicate and missing elements are 4 and 1, respectively

15. ![](./questions.md)
16. Find itinerary from the given list of departure and arrival airports
    Given a list of departure and arrival airports, find the itinerary in order. It may be assumed that departure is scheduled from every airport except the final destination, and each airport is visited only once, i.e., there are no cycles in the route.

For example,

Input:

HKG —> DXB
FRA —> HKG
DEL —> FRA

Output: DEL —> FRA —> HKG —> DXB

Input:

LAX —> DXB
DFW —> JFK
LHR —> DFW
JFK —> LAX

Output: LHR —> DFW —> JFK —> LAX —> DXB
17. Find the minimum difference between the index of two given elements present in an array:
    Given an integer array nums and two integers x and y present in it, find the minimum absolute difference between indices of x and y in a single traversal of the array.

For example,

Input:

arr = { 1, 3, 5, 4, 8, 2, 4, 3, 6, 5 }
x = 3, y = 2

Output: 2

Explanation: Element 3 is present at index 1 and 7, and element 2 is present at index 5. Their minimum absolute difference is min(abs(1-5), abs(7-5)) = 2

Input:

arr = { 1, 3, 5, 4, 8, 2, 4, 3, 6, 5 }
x = 2, y = 5

Output: 3

Explanation: Element 2 is present at index 5, and element 5 is present at index 2 and 9. Their minimum absolute difference is min(abs(5-2), abs(5-9)) = 3

18. Implement atoi to convert a string to an integer.

Example :

Input : "9 2704" Output : 9

Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

Questions:

Q1. Does string contain whitespace characters before the number?
A. Yes

Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it.

Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0.

Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise.

Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI

19. Rod Cutting Problem

Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n, find the optimal way to cut the rod into smaller rods to maximize profit.

For example, consider the following rod lengths and values:

Input:

length[] = [1, 2, 3, 4, 5, 6, 7, 8]
price[] = [1, 5, 8, 9, 10, 17, 17, 20]

Rod length: 4

Best: Cut the rod into two pieces of length 2 each to gain revenue of 5 + 5 = 10

Cut           Profit
4                9
1, 3            (1 + 8) = 9
2, 2            (5 + 5) = 10
3, 1            (8 + 1) = 9
1, 1, 2         (1 + 1 + 5) = 7
1, 2, 1         (1 + 5 + 1) = 7
2, 1, 1         (5 + 1 + 1) = 7
1, 1, 1, 1      (1 + 1 + 1 + 1) = 4

20. Given a list of non negative integers, arrange them such that they form the largest number.
    Example:
    Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

The result may be very large, so you need to return a string instead of an integer.

