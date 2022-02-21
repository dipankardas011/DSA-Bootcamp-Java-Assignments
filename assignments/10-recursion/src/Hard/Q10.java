package Hard;

public class Q10 {
    private int counter;
    private int empty = 1;

    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length;
    }

    private void solver(int[][] maze, int r, int c) {

        if (!isValid(r,c,maze) || maze[r][c] == -1)
            return ;

        if (maze[r][c] == 2) {
            if (empty == 0)
                counter++;
            return;
        }

        if (maze[r][c] == 0) {
            maze[r][c] = -1;
            empty--;

            solver(maze, r+1, c);
            solver(maze, r-1, c);
            solver(maze, r, c-1);
            solver(maze, r, c+1);

            empty++;
            maze[r][c] = 0;
        }
    }

    public int uniquePathsIII(int[][] grid) {
        int Di = 0, Dj = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    Di=i;
                    Dj=j;
                } else if (grid[i][j] == 0)
                    empty++;
            }
        }
        grid[Di][Dj] = 0;
        solver(grid, Di,Dj);
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Q10().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
