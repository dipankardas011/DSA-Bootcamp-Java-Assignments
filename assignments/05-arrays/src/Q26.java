import java.util.Arrays;

public class Q26 {
    public int[] plusOne(int[] digits) {
        int carry = 0;

        int len = digits.length - 1;
        int bit = 1;
        while (len >= 0) {
            bit += digits[len] + carry;
            digits[len] = bit%10;
            carry = bit/10;
            if (carry==0)
                break;
            len--;
            bit = 0;
        }
        if (carry>0) {
            // incrment the size
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            for (int i=0; i<digits.length; i++)
                ans[i+1] = digits[i];

            return ans;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q26().plusOne(new int[]{9})));
    }
}
