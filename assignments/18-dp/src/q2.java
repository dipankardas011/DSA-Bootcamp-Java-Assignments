package src;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @Doc first create a recusrive func
 * use memory to save the computation
 * use tabulation to further reduce time complexity by replacing the recustive calls to iterativr ones
 * then comes the space complexity use prev or curr array
 */
public class q2 {
    private boolean isValid(int i, int j, int m, int n) {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int uniquePathsRec(int m, int n) {
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            mem[i][j] = -1;
        }
    }
        return utilMem(0,0,m,n,mem);
//        return util(0,0,m,n);
    }

    public int uniquePathsTimeComplex(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int top = 0, left = 0;
                if (i > 0)
                    top = dp[i-1][j];
                if (j > 0)
                    left = dp[i][j-1];
                dp[i][j] = top + left;
            }
        }
        for (int[] rows :
                dp) {
            System.out.println(Arrays.toString(rows));
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        // dp[i-1][j]
        // ^
        // prev   [j]
        int[] prev=new int[n];
        for(int i=0; i<m; i++) {
            int[] temp=new int[n];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    temp[j]=1;
                    continue;
                }
                int up=0;
                int left =0;
                if(i>0)
                    up = prev[j];
                if(j>0)
                    left = temp[j-1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }





    private int utilMem(int i, int j, int m, int n, int[][] mem) {
        if (!isValid(i,j,m,n))
            return 0;
        if (i == m-1 && j == n-1)
            return 1;
        if (mem[i][j] != -1) {
            return mem[i][j];
        }

        int temp = utilMem(i,j+1,m,n,mem) + utilMem(i+1,j,m,n,mem);
        mem[i][j] = temp;
        return temp;
    }
    private int util(int i, int j, int m, int n) {
        if (!isValid(i,j,m,n))
            return 0;
        if (i == m-1 && j== n-1)
            return 1;
        return util(i,j+1, m,n) + util(i+1, j, m, n);
    }

    public static void main(String[] args) {
        System.out.println(new q2().uniquePathsTimeComplex(3, 7));
        System.out.println(new q2().uniquePathsTimeComplex(3, 2));
    }
}