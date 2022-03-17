package Hard;

/**
 * F** with the recursion mathematics
 */
public class Q1 {
    int m, n;

    private boolean checkIfZeroMat(int[][] matrix) {
        for (int[] row : matrix) {
            for (int ele : row) {
                if (ele == 1)
                    return false;
            }
        }
        return true;
    }
    public void flip(int[][] mat, int r, int c) {
        mat[r][c] ^= 1;
        if(r - 1 >= 0) mat[r-1][c] ^= 1;
        if(r + 1 <  m) mat[r+1][c] ^= 1;
        if(c - 1 >= 0) mat[r][c-1] ^= 1;
        if(c + 1 <  n) mat[r][c+1] ^= 1;
    }

    public int FlipOrNotFlip(int[][] mat, int row, int col) {
        if(col == n) {
            row++;
            col = 0;
        }
        if(row == m)
            return checkIfZeroMat(mat) ? 0 : 10000;

        int ret1 = FlipOrNotFlip(mat, row, col+1);
        flip(mat, row, col);
        int ret2 = 1 + FlipOrNotFlip(mat, row, col+1);
        return Math.min(ret1, ret2);
    }

    public int minFlips(int[][] mat) {
        n = mat[0].length;
        m = mat.length;
        int ret = FlipOrNotFlip(mat, 0, 0);
        return (ret >= 10000 ? -1 : ret);
    }

    public static void main(String[] args) {
        System.out.println(new Q1().minFlips(new int[][]{{0,0},{0,1}}));
        System.out.println(new Q1().minFlips(new int[][]{{1}}));
        System.out.println(new Q1().minFlips(new int[][]{{1, 0, 0}, {1, 0, 0}}));
        System.out.println(new Q1().minFlips(new int[][]{{1,1,1},{1,0,1},{0,0,0}}));
    }

}
