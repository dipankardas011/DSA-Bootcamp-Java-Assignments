package Easy;

public class Q10 {
    public int countNegatives(int[][] grid) {
        // start from the top-right if -ve we got the no of rows added as
        // the row below that row are going to be less than the number
        // so leave the col by col--;
        // if the right most scope is not -ve then leave the row++;

        int row = 0;
        int col = grid[0].length - 1;
        int m = grid.length;
        int ans = 0;
        while (row < m && col>=0) {
            // System.out.println("curr ans: "+ans+" row("+row+") col("+col+")");
            // check the right most of row
            if (grid[row][col] < 0) {
                //-ve
                //add it to the ans
                ans += m - row ;
                col--;
            } else {
                //+ve
                row++;
            }
        }
        return ans;
    }
}
