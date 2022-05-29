package Easy;

public class Q22 {
    public int maxProduct(int[] nums) {
        // find the max 2 numbers
        int m = 0, n = m; // constracing
        for (int num: nums) {
            if (num >= m) {
                n = m;
                m = num;
            }else if (num > n) {
                n = num;
            }
        }
        return (m - 1) * (n - 1);
    }
}
