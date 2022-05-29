package Medium;

public class Q5 {
    public int findMin(int[] nums) {
        int index = pivot(nums);
        if(index==-1) {
            // as the pivot is already sorted not rotated so the min is the [0]
            return nums[0];
        }
        //then the next of it is min as it is rotated
        return nums[(index+1)%nums.length];
    }
    public int pivot(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (mid<end && arr[mid]>arr[mid+1])
                return mid;
            if (mid > start && arr[mid-1]>arr[mid])
                return mid-1;

            if(arr[start]<arr[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
