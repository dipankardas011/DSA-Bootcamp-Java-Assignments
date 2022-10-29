def MaxSequenceDP(arr: list[int], total: int, index: int, mem: list[list[int]])-> int:
    if mem[index][total] != -1:
        return mem[index][total]

    if total < 0:
        return 0
    if total == 0:
        return 1
    if index < 0:
        return 0


    if total < arr[index]: # as the current ele is greater then desired sum for not considering it will help
        res = MaxSequenceDP(arr, total, index-1, mem)
    else:
        res = MaxSequenceDP(arr, total, index-1, mem)+ MaxSequenceDP(arr, total-arr[index], index-1, mem)


    mem[index][total] = res
    return res


def MaxSequence(arr: list[int], total: int, index: int)-> int:
    if total < 0:
        return 0
    if total == 0:
        return 1
    if index < 0:
        return 0
    if total < arr[index]: # as the current ele is greater then desired sum for not considering it will help
        return MaxSequence(arr, total, index-1)
    return (
        MaxSequence(arr, total, index-1)+
        MaxSequence(arr, total-arr[index], index-1)
    )


def LongestCommonSequence(p: str, q: str, m: int, n: int) -> int:
    if m == 0 or n == 0:
        return 0
    if p[m] == q[n]:
        res = 1 + LongestCommonSequence(p,q,m-1,n-1)
    else:
        res = max(
            LongestCommonSequence(p, q, m, n-1),
            LongestCommonSequence(p, q, m-1, n)
        )
    return res


def LongestCommonSequenceDP(p: str, q: str, m: int, n: int, mem: list[list[int]]) -> int:
    if mem[m][n] != -1:
        return mem[m][n]

    if m == 0 or n == 0:
        res = 0
    elif p[m] == q[n]:
        res = 1 + LongestCommonSequenceDP(p,q,m-1,n-1, mem)
    else:
        res = max(
            LongestCommonSequenceDP(p, q, m, n-1, mem),
            LongestCommonSequenceDP(p, q, m-1, n, mem)
        )
    mem[m][n] = res
    return res




# find all number of subsequence with same total
arr = [1,3,7,5,2]
total = 10

memory: list[list[int]] = [ [-1]*(total+1) ]*(len(arr))

print("No of Subsets using RT: %d"%MaxSequence(arr, total, len(arr)-1))
print("No of Subsets using DP: %d"%MaxSequenceDP(arr, total, len(arr)-1, memory))


str1 = "abb"
str2 = "bcb"
print(f"No of longest Common substrings b/w {str1} {str2} = {LongestCommonSequence(str1, str2, len(str1)-1, len(str2)-1)}")
mem: list[list[int]] = [ [-1] * (len(str2)) ] * (len(str1))
print(f"No of longest Common substrings b/w {str1} {str2} = {LongestCommonSequenceDP(str1, str2, len(str1)-1, len(str2)-1, mem)}")

str1 = "aaa"
str2 = "bbb"
print(f"No of longest Common substrings b/w {str1} {str2} = {LongestCommonSequence(str1, str2, len(str1)-1, len(str2)-1)}")
mem = [ [-1] * (len(str2)) ] * (len(str1))
print(f"No of longest Common substrings b/w {str1} {str2} = {LongestCommonSequenceDP(str1, str2, len(str1)-1, len(str2)-1, mem)}")


