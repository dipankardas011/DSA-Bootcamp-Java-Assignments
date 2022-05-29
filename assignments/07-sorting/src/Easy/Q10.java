package Easy;

public class Q10 {
    /**
     * @def We need not necessarily sort the given numsnums array to find the maximum product. Instead, we can only find the required 2 smallest values(min1min1 and min2min2) and the three largest values(max1, max2, max3max1,max2,max3) in the numsnums array, by iterating over the numsnums array only once.
     *
     * At the end, again we can find out the larger value out of min1 \times min2 \times max1min1×min2×max1 and max1 \times max2 \times max3max1×max2×max3 to find the required maximum product.
     * @param nums orig arr
     * @return max prod of 3
     */
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;// first lowest
        int min2 = Integer.MAX_VALUE;// second lowest

        int max1 = Integer.MIN_VALUE;// first max
        int max2 = Integer.MIN_VALUE;// second max
        int max3 = Integer.MIN_VALUE;// third max


        for(int n : nums) {
            if (min1 >= n) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }


            if (max1 <= n) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 <= n) {
                max3 = max2;
                max2 = n;
            } else if (max3 <= n){
                max3 = n;
            }
        }

        return Math.max(
                max1*max2*max3 ,
                min1*min2*max1
        );
    }
}
