package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q8 {

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

    private void utility(List<List<String>> ans, boolean[][] visited, int i) {
        if (i == visited.length) {
            List<String> res = new ArrayList<>();
            for (boolean[] row : visited) {
                StringBuilder str = new StringBuilder();
                for (boolean x : row) {
                    if (x)
                        str.append('Q');
                    else
                        str.append('.');
                }
                res.add(str.toString());
            }
            ans.add(res);
        }
        for (int k = 0; k < visited.length; k++) {
            if (isSafe(visited, i, k)) {
                visited[i][k] = true;
                utility(ans, visited, i+1);
                visited[i][k] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] isVisited = new boolean[n][n];
        List<List<String>> answer = new ArrayList<>();
        utility(answer, isVisited, 0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Q8().solveNQueens(4));
        System.out.println(new Q8().solveNQueens(1));
    }
}
