package src;
import java.util.*;
import java.lang.*;
import java.io.*;
public class CodeChef {
    int minCount = 0;

    private boolean isValid(int i, int j, int m, int n ){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    private int backtrack(int i, int j, int[][] special) {
        if (!isValid(i,j,special.length, special[0].length))
            return Integer.MAX_VALUE;
        if (i == 0 && j == 0) {
            return 1;
        }
        int[][] directions = new int[][]{
                {1,0},
                {-1,0},
                {0,-1},
                {0,1}
        };
        int[][] specialDir = new int[][]{
                {-1, -1},
                {1, 1},
                {1, -1},
                {-1, 1}
        };
        int xyz = Integer.MAX_VALUE;

        if (special[i][j] == 9) {
            for (int[] dir: specialDir) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                xyz = Math.min(xyz, backtrack(x,y,special));
            }
        }
        for (int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            xyz = Math.min(xyz, backtrack(x,y,special));
        }
        return xyz;
    }
    private int exec(int N, int M, int[][] special) {
        return backtrack(N, M, special);
    }
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n, m, k;
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
//            ArrayList<int[]> special = new ArrayList<>();
            int[][] special = new int[n][m];
            while (k-- > 0) {
                int i, j;
                i = in.nextInt();
                j = in.nextInt();
                special[i-1][j-1] = 9;
//                special.add(new int[]{i, j});
            }
            System.out.println(new CodeChef().exec(n-1,m-1,special));
        }
    }
}
