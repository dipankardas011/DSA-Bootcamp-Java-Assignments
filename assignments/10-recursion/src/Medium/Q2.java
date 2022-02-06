package Medium;

public class Q2 {
    boolean[][] visited;
    private boolean isSafe(int i, int j, int lenR, int lenC) {
        return i < lenR && i >= 0 && j < lenC && j >= 0;
    }
    private boolean utility(
            char[][] board,
            String word,
            int indStr,
            int row, int col
    )
    {
        if (indStr == word.length())
            return true;

        if (!isSafe(row,col, board.length, board[0].length)
                || board[row][col] != word.charAt(indStr) ||
                visited[row][col]) {
            return false;
        }

        visited[row][col]=true;

        if (
                utility(board, word, indStr+1, row-1, col)
                || utility(board, word, indStr+1, row+1, col)
                || utility(board, word, indStr+1, row, col-1)
                || utility(board, word, indStr+1, row, col+1)
        )
            return true;

        visited[row][col]=false;

        return false;
    }

    public boolean exist(char[][] board,
                         String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) &&
                        utility(board, word, 0, i,j))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q2 o = new Q2();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(o.exist(board, "ABCCED"));
        System.out.println(o.exist(board, "SEE"));
        System.out.println(o.exist(board, "ABCB"));
    }
}
