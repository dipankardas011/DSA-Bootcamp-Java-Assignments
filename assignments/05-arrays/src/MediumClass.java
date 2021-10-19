import java.util.ArrayList;
import java.util.List;

public class MediumClass {
}

class Q1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int minc = 0;
        int minr = 0;
        int maxr = matrix.length;
        int maxc = matrix[0].length;

        int maxCount = (maxr) * (maxc) ;

        int count = 0;

        while (count < maxCount) {
            // top elements
            for (int top = minc; top <maxc && count < maxCount; top++) {
                ans.add(matrix[minr][top]);
                count++;
            }
            // right elements
            for (int right = minr + 1; right < maxr && count < maxCount; right++) {
                ans.add(matrix[right][maxc-1]);
                count++;
            }

            // bottom elements
            for (int bottom = maxc - 2; bottom >= minc && count < maxCount; bottom--) {
                ans.add(matrix[maxr-1][bottom]);
                count++;
            }

            // left elements
            for (int left = maxr - 2; left > minr && count < maxCount; left--) {
                ans.add(matrix[left][minc]);
                count++;
            }
            minr++;
            minc++;
            maxc--;
            maxr--;
        }


        return ans;
    }

}

class Q3 {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] output_arr = new int[N];
        output_arr[0] = 1;

        for (int i=1;i<N;i++){
            output_arr[i] = nums[i-1]*output_arr[i-1];
        }

        // prod
        int r = 1;
        for (int i=N-1;i>=0;i--){
            output_arr[i] =output_arr[i]*r;
            r*= nums[i];
        }

        return output_arr;
    }
}

class Q4 {
    public int[] searchRange(int[] nums, int target) {
        // sorted arr is binary search
        int[] ans = new int[]{-1,-1};
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1)
            ans[1] = binarySearch(nums, target, false);
        return ans;
    }
    public int binarySearch (int[] arr, int target, boolean searchFirst) {
        int start = 0;
        int end = arr.length-1;
        int pos = -1;

        while (start<=end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == target) {
                pos = mid;
                if (searchFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid -1 ;
            } else {
                start = mid +1;
            }
        }
        return pos;
    }
}

class Q5 {
    public boolean canJump(int[] nums) {
        int I = nums.length - 1;
        int jumps = 1;
        while (I > 0) {
            if (nums[I-1] < jumps) // it is not capable to jump so increment jump  if the left of it can manage then it will reset to jumps = 1
                jumps++;
            else//[I-1] > jumps
                jumps=1;
            I--;
        }
        /***
         * @return if the jumps we can reach and not reach of not !=1
         */
        return jumps==1;
    }
}

class Q6 {
    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] =t ;
    }
    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int noRotation = k%(nums.length);
        /***
         * example 1 2 3 4 k = 3
         * first step is to reverse the first half then second half and then reverse th
         * whole arr
         * noRotation = is the number of elemetnto come first
         */
        int l = -1, r = -1;
        l = 0;
        r = nums.length - 1 - noRotation;
        reverse(nums, l, r);
        // here it will become 1 2 3 4
        // then reverse the second half
        l = nums.length - noRotation;
        r = nums.length-1;
        reverse(nums, l, r);

        // here 1 4 3 2
        //reverse to get 2 3 4 1
        l = 0;r = nums.length-1;
        reverse(nums, l, r);

    }
}