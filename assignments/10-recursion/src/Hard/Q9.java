package Hard;

import java.util.ArrayList;
import java.util.List;

public class Q9 {
    private boolean isSafe(boolean[][] isVisited, int i, int j) {
        for (int rowww = 0; rowww < i; rowww++) {
            if (isVisited[rowww][j])
                return false;
        }
        int row = i;
        int col = j;
        while (row >= 0 && col >= 0) {

            if (isVisited[row][col])
                return false;
            row--;
            col--;
        }

        row = i;
        col = j;
        while (row >= 0 && col < isVisited.length) {
            if (isVisited[row][col])
                return false;
            row--;
            col++;
        }
        return true;

    }

    private int utility(boolean[][] visited, int i) {
        if (i == visited.length) {
            return 1;
        }
        int count = 0;
        for (int k = 0; k < visited.length; k++) {
            if (isSafe(visited, i, k)) {
                visited[i][k] = true;
                count += utility(visited, i+1);
                visited[i][k] = false;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        boolean[][] isVisited = new boolean[n][n];
        return utility(isVisited, 0);
    }
    public static void main(String[] args) {
        System.out.println(new Q9().totalNQueens(4));
        System.out.println(new Q9().totalNQueens(1));
    }
}
