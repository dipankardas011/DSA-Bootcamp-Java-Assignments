package Easy;

public class Q8 {

    /**
     * Complement a number
     * @param num
     * @return
     */
    public int findComplement(int num) {
        if (num == 1)
            return 0;

        int base = 1;
        int ans = 0;
        while (num > 0) {

            ans += base * ((num & 1) == 1 ? 0 : 1 );

            base <<= 1;
            num >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q8().findComplement(5));
        System.out.println(new Q8().findComplement(10));
        System.out.println(new Q8().findComplement(1));
    }
}
