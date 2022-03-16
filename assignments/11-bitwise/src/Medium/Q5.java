package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q5 {
    private int binaryToGrayCode(int number, int bitLength) {
        int res = 0, i;
        for (i = 0; i < bitLength-1; i++) {
            int right = number & 1;
            int left = (number >> 1) & 1;
            res += (right ^ left) * (1 << i);
            number >>= 1;
        }
        res += (number & 1) * (1 << i); // adding the MSB
        return res;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) {
            ll.add(binaryToGrayCode(i, n));
        }
        return ll;
    }
    public static void main(String[] args) {
        System.out.println(new Q5().grayCode(1));
    }
}
