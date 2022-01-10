package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: s = "TO BE OR NOT TO BE"
 * Output: ["TBONTB","OEROOE","   T"]
 * Explanation: Trailing spaces is not allowed.
 * "TBONTB"
 * "OEROOE"
 * "   T"
 */
public class Q19 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");

        List<String> ans = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        for (String ss : words)
            maxLen = Math.max(maxLen, ss.length());

        int iter = 0;
        while (iter < maxLen) {
            StringBuilder str = new StringBuilder();
            for (int i=0; i<words.length; i++) {
                if (iter < words[i].length()) {
                    str.append(words[i].charAt(iter));
                } else {
                    str.append(" ");
                }
            }
            while (Character.isWhitespace(str.charAt(str.length()-1))) {
                str.deleteCharAt(str.length()-1);
            }

            ans.add(str.toString());

            iter++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Q19 o = new Q19();
        System.out.println(o.printVertically("HOW ARE YOU"));
        System.out.println(o.printVertically("TO BE OR NOT TO BE"));
        System.out.println(o.printVertically("CONTEST IS COMING"));
    }
}
