import java.util.Arrays;

public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for (int[] pair : trust) {
            count[pair[0]]--; // if the person trust someone we will reduce its trustCounter
            count[pair[1]]++; // and increase the trusted person counter
        }
        // the goal is person has 0 but is trusted by all n-1
        for (int i = 1; i <= n; i++) {
            if (count[i] == n-1)
                return i;
        }
        return -1;
    }
}
