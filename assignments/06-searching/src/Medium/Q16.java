package Medium;

public class Q16 {
    public static int shipWithinDays(int[] weights, int days) {
        int start=weights[0] ,end =weights[0];
        for (int iter : weights) {
            start = Math.max(start, iter);
            end += iter;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int NoOfSubArr = 1;
            int sum = 0;
            for (int i : weights) {
                if(sum + i > mid)
                {
                    sum = i;
                    NoOfSubArr++;
                } else
                    sum += i;
            }

            if (NoOfSubArr > days)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
