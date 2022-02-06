package Easy;

public class Q1 {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder str = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = carry + (a.charAt(i)-'0') + (b.charAt(j)-'0');
            carry = sum/2;
            sum %=2;
            str.append(Integer.toString(sum));
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = carry + (a.charAt(i)-'0');
            carry = sum/2;
            sum %=2;
            str.append(Integer.toString(sum));
            i--;
        }

        while (j >= 0) {
            int sum = carry + (b.charAt(j)-'0');
            carry = sum/2;
            sum %=2;
            str.append(Integer.toString(sum));
            j--;
        }
        if (carry > 0)
            str.append(carry);

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Q1 o = new Q1();
        System.out.println(o.addBinary("10001","100111"));
        System.out.println(o.addBinary("11","1"));
        System.out.println(o.addBinary("1010","1011"));
    }
}
