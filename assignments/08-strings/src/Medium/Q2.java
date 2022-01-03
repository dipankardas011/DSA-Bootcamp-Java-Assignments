package Medium;

/**
 * Q2
 */
public class Q2 {
    public boolean isPa(String s, int i, int j) {
        for (; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public boolean check(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < j; ++i, --j)
            if (a.charAt(i) != b.charAt(j))
                return isPa(a, i, j) || isPa(b, i, j);
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public static void main(String[] args) {

    }
}