package Medium;

public class Q33 {

    int srcRow, srcCol;
    int destRow, destCol;

    public Q33(int srcRow, int srcCol, int destRow, int destCol) {
        this.srcRow = srcRow;
        this.srcCol = srcCol;
        this.destRow = destRow;
        this.destCol = destCol;
    }

    private void dis(int[][] maze) {
        for (int[] row : maze) {
            for (int c : row) {
                switch (c) {
                    case 0-> System.out.print("▩ ");
                    case 1-> System.out.print("▢ ");
                    case 5-> System.out.print("▲ ");
                    default -> System.out.println("  ");
                }
            }
            System.out.println();
        }
    }

    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && c >= 0 && r < maze.length && c < maze.length;
    }

    private boolean solver(int[][] maze, int r, int c) {

        if (!isValid(r,c,maze) || maze[r][c] != 1)
            return false;
        // down and right
        if (r == destRow && c == destCol) {
//            dis(maze);
            maze[r][c] = 5;

            return true;
        }

        if (maze[r][c] == 1) {
            maze[r][c] = 5;

            if (solver(maze, r+1, c))
                return true;
            if (solver(maze, r-1, c))
                return true;
            if (solver(maze, r, c-1))
                return true;
            if (solver(maze, r, c+1))
                return true;

            maze[r][c] = 1;
            return false;
        }
        return false;
    }

    public void solveMaze(int[][] maze) {
        if (solver(maze,srcRow, srcCol))
            dis(maze);
        else
            System.err.println("ERR");
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        Q33 oo = new Q33(0,0, maze.length-1, maze.length-1);
        oo.dis(maze);
        System.out.println();
        oo.solveMaze(maze);
    }
}