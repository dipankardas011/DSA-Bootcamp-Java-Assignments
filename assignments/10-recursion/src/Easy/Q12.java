package Easy;

public class Q12 {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;

        while (n % 3 == 0)
            n /= 3;

        return n == 1;
    }

    public static void main(String[] args) {
        Q12 o = new Q12();
        System.out.println(o.isPowerOfThree(45));
    }
}
