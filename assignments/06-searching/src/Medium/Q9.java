package Medium;

public class Q9 {
    /**
     * doubt
     * @param n size of the arr
     * @param index index value of max
     * @param maxSum maximum sum
     * @return the nums[index]
     */
    public int maxValue(int n, int index, int maxSum) {
        /**
         * We first do maxSum -= n,
         * then all elements needs only to valid A[i] >= 0
         *
         * We binary search the final result between left and right,
         * where left = 0 and right = maxSum.
         *
         * For each test, we check minimum sum if A[index] = a.
         * The minimum case would be A[index] is a peak in A.
         * It's arithmetic sequence on the left of A[index] with difference is 1.
         * It's also arithmetic sequence on the right of A[index] with difference is -1.
         *
         * On the left, A[0] = max(a - index, 0),
         * On the right, A[n - 1] = max(a - ((n - 1) - index), 0),
         *
         * The sum of arithmetic sequence {b, b+1, ....a},
         * equals to (a + b) * (a - b + 1) / 2.
         *
         *
         * Complexity
         * Because O(test) is O(1)
         * Time O(log(maxSum))
         * Space O(1)
         */
        maxSum -= n;
        int left = 0;
        int end = maxSum;

        while (left < end) {
            int mid = (left+end+1)>>1;

            if (checkCondition(n, index, mid) <= maxSum)
                left = mid;
            else
                end = mid -1;
        }
        return left+1;
    }

    private long checkCondition(int n, int index, int mid) {
        // left side
        int b = Math.max(mid-index, 0);//if +ve then b=+ve number otherwise 0
        long res = (long) (mid + b) * (mid - b + 1) >> 1;

        b = Math.max(mid -(n-1 - index), 0); // right side of mid as -ve is converted to +ve from n-1
        res += (long) (mid + b) * (mid - b + 1) >> 1;
        return res - mid;// mid is calculated 2X so -mid
    }

    public static void main(String[] args) {
        Q9 o = new Q9();
        System.out.println(o.maxValue(4,2,6));
        System.out.println(o.maxValue(6,1,10));
    }
}
