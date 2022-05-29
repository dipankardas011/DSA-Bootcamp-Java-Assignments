package Medium;

public class Q2 {
    public int singleNonDuplicate(int[] nums) {
        // how to know that element is the ONE
        // as [mid] != [mid+1] and [mid] != [mid-1]
        // as gurantied that exactly 2 repetation

        if(nums.length==1)
            return nums[0];

        int start = 0;
        int len = nums.length;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < len-1  && nums[mid]==nums[mid+1])
                if((end-mid-1)%2==0)
                    end = mid-1;
                else
                    start = mid+2;


            else if (mid > 0 && nums[mid]==nums[mid-1])
                if ((mid-start-1)%2==0)//mid is accounting for the mid-1 as index is 0 based
                    start = mid+1;
                else
                    end = mid-2;

            else
                return nums[mid];
        }
        return -1;
    }

    public static void main(String[] args) {
        Q2 o =new Q2();
        System.out.printf("Ans: %d\n",o.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));// ans = 10
    }
}
