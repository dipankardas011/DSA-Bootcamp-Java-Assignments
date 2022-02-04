package Medium;

public class Q22 {

    private boolean isSafe(
            char[][] board,
            int row, int col, int numToPut) {
        //check the col
        for (char[] chars : board) {
            if (chars[col] == numToPut) {
                return false;
            }
        }

        // check the row
        for (int coli = 0; coli < board[0].length; coli++) {
            if (board[row][coli] == numToPut) {
                return false;
            }
        }

//        int sizier = board.length / 3;
        // assumning that board size % 3 == 0
        // and that board has 3x3 smaller boxes
        int sizier = (int)Math.sqrt(board.length); // means that 4x4 4 is the smallest box size
        int startR = row - (row%sizier);
        int startC = col - (col%sizier);

        for (int i = startR; i < startR+ sizier; i++) {
            for (int j = startC; j < startC+ sizier; j++) {
                if (board[i][j] == numToPut)
                    return false;
            }
        }
        return true;
    }

    private boolean utility(char[][] board) {
        int row = -1;
        int col = -1;
        boolean isThereSpace = false;
        outer:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    isThereSpace = true;
                    break outer;
                }
            }
        }
        if (!isThereSpace) {
            return true;
        }

        for (char number = '1'; number <= '9'; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (utility(board)) {
                    return true;
                } else {
                    // the guess was wrong
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        utility(board);
    }
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new Q22().solveSudoku(board);

        for (char[] row: board) {
            for (char cc :row) {
                System.out.print(cc + " ");
            }
            System.out.println();
        }
    }
}