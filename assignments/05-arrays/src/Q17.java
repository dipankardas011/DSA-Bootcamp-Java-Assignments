import java.util.Arrays;

public class Q17 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[n][m];
        // System.out.println("m: "+ m + " n: " + n);
        //column wise
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                res[col][row] = matrix[row][col];
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Q17 ob = new Q17();
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }

        arr = ob.transpose(arr);
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
