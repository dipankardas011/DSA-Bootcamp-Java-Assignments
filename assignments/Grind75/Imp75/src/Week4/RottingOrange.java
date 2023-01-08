package Week4;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        int leftOrange = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    leftOrange++;
                }
            }
        }
        if (leftOrange == 0)
            return 0;
        int minutes = 0;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    if (x < 0 || y < 0 ||
                            x >= rows || y >= cols ||
                            grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});
                    leftOrange--;
                }
            }
        }
        return (leftOrange == 0) ? minutes-1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(new RottingOrange().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
