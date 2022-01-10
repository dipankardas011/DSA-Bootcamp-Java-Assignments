package Medium;

public class Q13 {
    public int countHomogenous(String s) {
        int mod = (int)1e9 + 7;
        int res = 0;
        char prev = ' ';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == prev) {
                count++;
            } else {
                prev = ch;
                count=1;
            }
            res = (res+count)%mod;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
