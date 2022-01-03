package Medium;

public class Q1 {
    /**
     * It's a bottom-up DP implementation. The boolean value represents whether this
     * position is reachable from start. So the first step is to generate the table.
     * Here the table was pre-labeled True or False, thus '1's are already labeled
     * False.
     * To determine the state of dp[i], one need to check the states in window
     * dp[i-maxJ : i-minJ], because any one of them can reach i if it's labeled
     * True.
     * Then you need to check if there is a True in this window. Notice that this is
     * a sliding window problem, so you don't need to calculate it everytime. You
     * only need to remove the effect from dp[i-maxJ-1] and add the dp[i-minJ]. This
     * is done by these two lines of code pre += dp[i - minJ] and pre -= dp[i - maxJ
     * - 1]
     * The if statements if i >= minJ: and if i > maxJ: are dealing with the initial
     * boundary.
     * 
     * @param s
     * @param minJ
     * @param maxJ
     * @return boolean
     */
    public boolean canReach(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ])
                pre++;
            if (i > maxJ && dp[i - maxJ - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Q1 ob = new Q1();
        String s = "011010";
        int minJ = 2;
        int maxJ = 3;
        System.out.println(ob.canReach(s, minJ, maxJ));
    }
}

class Solution {

    private boolean finding(String s, int mJ, int MJ, int i) {
        if (i == s.length() - 1)
            return true;

        int Min = i + mJ;
        int Max = Math.min(i + MJ, s.length() - 1);
        for (int j = Min; j <= Max; j++) {
            if (s.charAt(j) == '0') {
                boolean res = finding(s, mJ, MJ, j);
                if (res)
                    return true;
            }
        }
        return false;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        return finding(s, minJump, maxJump, 0);
    }
}