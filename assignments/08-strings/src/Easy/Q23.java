package Easy;

public class Q23 {

    private int valueOfIt(char ch) {
        int n = 0;
        switch (ch) {
            case 'I':
                n = 1;
                break;
            case 'V':
                n = 5;
                break;
            case 'X':
                n = 10;
                break;
            case 'L':
                n = 50;
                break;
            case 'C':
                n = 100;
                break;
            case 'D':
                n = 500;
                break;
            case 'M':
                n = 1000;
                break;
        }
        return n;
    }

    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int a = valueOfIt(s.charAt(i));
            int b = valueOfIt(s.charAt(i + 1));

            if (b > a) {
                ans -= a;
            } else {
                ans += a;
            }
        }
        ans += valueOfIt(s.charAt(s.length() - 1));
        return ans;

    }

    public static void main(String[] args) {

    }
}