package Week5;

public class RotatedSortedArraySearch {
    public int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int partitionIdx = -1;
        while (left <= right) {
            int middle = left + (right - left)/ 2;
            // 4 5 6 7 0 1 2 3
            // ^     ^       ^
            if (middle < right && nums[middle] > nums[middle+1]) {
                partitionIdx = middle;
                break;
            }
            // 4 5 0 1 2
            // ^   ^   ^
            if (left < middle && nums[middle-1] > nums[middle]) {
                partitionIdx = middle - 1;
                break;
            }
            // 5 0 1 2 3
            // ^   ^   ^
            if (nums[middle] <= nums[left])
                right = middle -1;
            else
                left = middle+1;
        }
        if (partitionIdx == -1)
            return binarySearch(nums, target, 0 , nums.length - 1);
        if (nums[partitionIdx] == target) {
            return partitionIdx;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, partitionIdx - 1);
        }

        return binarySearch(nums, target, partitionIdx + 1, nums.length - 1);
    }
    public static void main(String[] args) {
        System.out.println(new RotatedSortedArraySearch().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new RotatedSortedArraySearch().search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(new RotatedSortedArraySearch().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
