package Medium;


public class Q4 {
    public long divide(int dividend, int divisor) {
        if (dividend >= 0 && divisor > 0) {
            return dividing(dividend, divisor);
        } else if (dividend < 0 && divisor > 0) {
            return -1 * dividing(-(long)dividend, divisor);
        } else if (dividend >= 0 && divisor < 0) {
            return -1 * dividing(dividend, -(long)divisor);
        } else {
            return dividing(-(long)dividend, -(long)divisor);
        }
    }

    private long dividing(long dividend, long divisor) {

        long count = 0;
        while (dividend >= divisor) {
            count++;
            dividend -= divisor;
        }

        return count;
    }
    public int dividev2(int A, int B) {
        if (A == 1 << 31 && B == -1)
            return (1 << 31) - 1;
        int a = Math.abs(A),
                b = Math.abs(B),
                res = 0,
                x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().divide(10,3));
        System.out.println(new Q4().divide(0,-3));
        System.out.println(new Q4().divide(7,-3));
        System.out.println(new Q4().divide(-3,-3));
        System.out.println(new Q4().divide(7,-1));

        System.out.println(new Q4().divide((1<<31) - 1,-1));
        System.out.println(new Q4().divide(-(1<<31),-1));
    }
}
