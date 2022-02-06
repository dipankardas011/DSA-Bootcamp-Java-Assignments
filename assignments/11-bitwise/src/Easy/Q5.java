package Easy;

import java.util.Arrays;

public class Q5 {

    private int countSetBits(int number) {
        int count = 0;
        while (number > 0) {
            count += number&1;
            number >>= 1;
        }
        return count;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            ans[i] = countSetBits(i);
            //         for (int i = 1; i < n + 1; i++) {
            //            ans[i] = ans[i>>1]+i%2;
            //        }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q5().countBits(2)));
    }
}
