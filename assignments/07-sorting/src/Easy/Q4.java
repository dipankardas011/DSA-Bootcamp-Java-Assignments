package Easy;

public class Q4 {
    public int missingNumber(int[] nums) {
        // here the index = 0...n-1
        // but the element can be 0...n
        // so if the number is num.length <= element skip it
        int index = 0;
        while (index < nums.length) {
            if (index != nums[index]) {
                if (nums[index] >= nums.length) {
                    index++;
                } else {
                    swap(nums, index, nums[index]);
                }
            } else{
                index++;
            }
        }

        for (int  i =0; i<nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return nums.length;// if not found then the last element is not there (n)
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i]= a[j];
        a[j] = t;
    }
}
