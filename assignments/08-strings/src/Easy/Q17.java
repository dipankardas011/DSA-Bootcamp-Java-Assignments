package Easy;

public class Q17 {
    public boolean validPalindrome(String s) {
        int left, right;
        for (left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                // a ***** b
                // a is ignore
                int i1 = left + 1, j1 = right;

                // b is ignore
                int i2 = left, j2 = right - 1;

                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) {
                    i1++;
                    j1--;
                }

                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) {
                    i2++;
                    j2--;
                }

                return i1 >= j1 || i2 >= j2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q17 ob = new Q17();
        System.out.println(ob.validPalindrome("abca"));
    }
}
