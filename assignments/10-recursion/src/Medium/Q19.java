package Medium;

import java.util.ArrayList;

public class Q19 {
    private String getBinary(int n, int len) {
        StringBuilder str = new StringBuilder();
        int i = n;
        while (i != 0) {
            str.append(i&1);
            i >>= 1;
        }
        while (str.length() < len) str.append('0');
        return str.reverse().toString();
    }

    ArrayList<String> grayCode(int n) {
        // here the n is the length
        int N = (1<<(n-1));
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < (N<<1); i++) {
            int prevComp = i >> 1;
            int ss = i^prevComp;    // this line is critical
            res.add(getBinary(ss, n));
        }
        return res;
    }

    public static void main(String[] args) {
        Q19 o = new Q19();
        System.out.println(o.grayCode(3).toString());
    }
}