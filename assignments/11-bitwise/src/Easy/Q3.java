package Easy;

import java.math.BigInteger;

public class Q3 {

    int reverseBits(int n ) {

        int m = 0;
        for (int i = 0; i < 32; i++) {
            m <<= 1;
            m |= n&1;
            n >>=1;
        }
        return m;
    }


    public static void main(String[] args) {

    }
}
