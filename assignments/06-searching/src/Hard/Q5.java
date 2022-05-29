package Hard;

public class Q5 {
    public int splitArray(int[] nums, int m) {
        int start=nums[0] ,end =nums[0];
        for (int iter : nums) {
            start = Math.max(start, iter);
            end += iter;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int NoOfSubArr = 1;
            int sum = 0;
            for (int i : nums) {
                if(sum + i > mid)
                {
                    sum = i;
                    NoOfSubArr++;
                } else
                    sum += i;
            }

            if (NoOfSubArr > m)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
