package Medium;

public class Q12 {
    public int numSub(String s) {
        int res = 0, count = 0, mod = (int)1e9 + 7;

        for (char ch : s.toCharArray()) {
            count = ch == '1' ? count + 1 : 0;
            res = (res+count)%mod;
        }
        return res;
    }
}
