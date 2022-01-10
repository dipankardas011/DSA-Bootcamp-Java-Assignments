package Hard;

import java.util.Arrays;

public class Q7 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);

                if (temp.compareTo(ans) < 0)
                    ans = temp;
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Q7().orderlyQueue("cba", 1));
    }
}
