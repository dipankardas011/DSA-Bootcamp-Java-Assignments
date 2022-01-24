package Medium;

public class Q6 {
    static long mod = (long)1e9 + 7;
    public int countGoodNumbers(long n) {
        /**
         * SAME IDEA
         * Now, we know we have 4 primes = {2, 3, 5, 7} and 5 evens = {0, 2, 4, 6, 8}
         * if index == 0
         * then there can be any of one evens at even position, so 5 ways
         * ans = 5
         * if index == 1
         * then there was 1 even at index = 0, and at this odd index there can be one of 4 primes
         * ans = 5* 4(this pos)
         * so, continuing the pattern we can see, it's like, 5*4*5*4*5*4*5..... ans so on
         * ans = pow(4, odd positions) * pow(5,even positions)
         *
         * here no. of 4s = no. of odd positions = n/2
         * no. of 5s = no. of even positions = (n-n/2)
         */
        long oddPositions = n >> 1;
        long evenPositions = n - (n >> 1);
//        optimization needed for the power
        return (int)((power(5,evenPositions) * power(4,oddPositions))%mod);
    }

    private long power(long base, long power) {
        /**
         * If n is even, replace x^n by (x^2)^(n/2).
         * If n is odd, replace x^n by x.x^(n-1).   => x * x^2,n-1/2
         * n-1 becomes even and you can apply the relevant formula again.
         */
        if (power == 0)
            return 1;

        if ((power & 1) == 0) {
            return power((base*base)%mod, power>>1);
        } else {
            return (base * power(base, power-1) ) % mod;
        }
    }

    public static void main(String[] args) {
        Q6 o = new Q6();
        System.out.println(o.countGoodNumbers(1));
        System.out.println(o.countGoodNumbers(4));
        System.out.println(o.countGoodNumbers(50));
    }
}
