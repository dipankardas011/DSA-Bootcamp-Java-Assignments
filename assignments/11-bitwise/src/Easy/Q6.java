package Easy;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public List<String> readBinaryWatch(int num) {
        if (num > 9)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (int hrs = 0; hrs < 12; hrs++) {
            for (int mins = 0; mins < 60; mins++) {
                if (Integer.bitCount(hrs) + Integer.bitCount(mins) == num)
                    res.add(String.format("%d:%02d", hrs, mins));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q6 o = new Q6();
        System.out.println(o.readBinaryWatch(1));
    }
}
