package Medium;

public class Q4 {
    public boolean search(int[] nums, int target) {
        int pivot = pivotDuplicates(nums);

        if (pivot==-1) {
            //not rotated
            return binarySearch(nums, 0, nums.length-1, target);
        }
        if (nums[pivot]==target)
            return true;

        boolean k = binarySearch(nums, 0, pivot-1, target);

        if(!k)
            return binarySearch(nums, pivot+1, nums.length-1, target);
        return true;
    }

    public boolean binarySearch(int[] n, int s, int e, int t) {
        while(s <= e) {
            int mid = s+(e-s)/2;

            if (n[mid] > t)
                e=mid-1;
            else if (n[mid] < t)
                s=mid+1;
            else
                return true;
        }
        return false;
    }

    public int pivotDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid<end && nums[mid] > nums[mid+1])
                return mid;
            if (mid>start && nums[mid-1] > nums[mid])
                return mid-1;

            if (nums[start] == nums[mid] && nums[mid] == nums[end])
            {
                if(start < end && nums[start] > nums[start+1])
                    return start;
                start++;

                if(end > start && nums[end-1] > nums[end])
                    return end-1;
                end--;
            }
            else if (nums[start] < nums[mid] ||
                    (nums[start]==nums[mid] && nums[mid] > nums[end]))
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }


    public static void main(String[] args) {
        Q4 o = new Q4();
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int t = 2;
        System.out.println(o.pivotDuplicates(arr));
        System.out.println(o.search(arr, t));
    }
}
