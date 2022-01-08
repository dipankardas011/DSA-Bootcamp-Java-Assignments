package Medium;

public class Q14 {
    public int equalSubstring(String s, String t, int maxLen) {
        int n = s.length();
        int left = 0,
                right = 0;
        while (right < n) {
            maxLen -= Math.abs(s.charAt(right) - t.charAt(right));

            if (maxLen < 0) {
                maxLen += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            right++;
        }
        return right - left;
    }
}
