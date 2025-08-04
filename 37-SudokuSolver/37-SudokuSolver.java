// Last updated: 8/4/2025, 6:01:54 PM
class Solution {

    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }

    public boolean isSafe(char[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (num + '0')) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char) (num + '0')) {
                return false;
            }
        }

        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (num + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solver(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        int nrow = row, ncol = col + 1;
        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        }

        if (board[row][col] != '.') {
            return solver(board, nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');

                    if (solver(board, nrow, ncol)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
        }

        return false;
    }
}
