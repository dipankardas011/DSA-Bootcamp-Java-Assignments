package Easy;

public class Q10 {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;

        while (n > 0) {
            if (prev == (n&1)) return false;

            prev = n&1;
            n >>=1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q10().hasAlternatingBits(5));
        System.out.println(new Q10().hasAlternatingBits(11));
        System.out.println(new Q10().hasAlternatingBits(7));
    }
}
