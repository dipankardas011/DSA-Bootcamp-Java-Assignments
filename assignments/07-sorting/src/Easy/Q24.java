package Easy;

import java.util.Arrays;

public class Q24 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        // fix any combination
        int d = Math.abs(arr[0] - arr[1]);
        for (int i=1; i<arr.length; i++) {
            if (d != Math.abs(arr[i-1] - arr[i]))
                return false;
        }
        return true;
    }
}
