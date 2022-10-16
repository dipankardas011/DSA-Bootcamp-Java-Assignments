class Solution:

    def binarySearch(self, arr: List[int], target: int, left: int, right: int) -> int:
        if left <= right:
            mid = left + (right-left)//2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                return self.binarySearch(arr, target, left, mid-1)
            else:
                return self.binarySearch(arr, target, mid+1, right)
        else:
            return -1

    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums, target, 0, (len(nums)-1))
