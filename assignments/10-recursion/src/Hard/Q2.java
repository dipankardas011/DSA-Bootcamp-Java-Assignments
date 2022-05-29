package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2 {
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') count++;
            else
                count--;
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        res.sort(Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        System.out.println(new Q2().makeLargestSpecial("11011000"));
    }
}
