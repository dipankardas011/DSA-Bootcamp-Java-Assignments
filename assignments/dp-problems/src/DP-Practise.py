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

# find all number of subsequence with same total
arr = [1,3,7,5,2]
total = 10

memory: list[list[int]] = [ [-1]*(total+1) ]*(len(arr))

print("No of Subsets using RT: %d"%MaxSequence(arr, total, len(arr)-1))
print("No of Subsets using DP: %d"%MaxSequenceDP(arr, total, len(arr)-1, memory))
