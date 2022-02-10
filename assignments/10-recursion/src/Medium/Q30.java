package Medium;

public class Q30 {

    private int maxCount;

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxCount = Math.max(maxCount, utility(grid, i,j));
            }
        }
        return maxCount;
    }

    private int utility(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= 0)
            return 0;
        grid[r][c] = -grid[r][c];
        int res = Math.max(
                        Math.max(utility(grid, r-1, c), utility(grid, r+1, c)),
                        Math.max(utility(grid, r, c-1), utility(grid, r, c+1))
                );
        grid[r][c] = -grid[r][c];
        res += grid[r][c];
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(new Q30().getMaximumGold(grid));
    }
}