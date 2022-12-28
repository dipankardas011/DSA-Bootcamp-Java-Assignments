import java.util.*;

public class numberofIslands {
  
  void FloodAllIslandsNear(char[][] grid, int x, int y) {
        if (x < 0 || x>= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1')
            return ;
        grid[x][y] = '0';
        FloodAllIslandsNear(grid,x-1, y);
        FloodAllIslandsNear(grid,x+1, y);
        FloodAllIslandsNear(grid,x, y-1);
        FloodAllIslandsNear(grid,x, y+1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    FloodAllIslandsNear(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
  public static void main(String[] args) {
    
  }
}
