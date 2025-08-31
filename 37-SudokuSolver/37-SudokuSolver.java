// Last updated: 8/31/2025, 4:53:08 PM
class Solution {
    public void solveSudoku(char[][] board) {
        solver(0, 0, board);        
    }

    public static boolean solver(int row, int col, char[][] board) {
        if(row == 9) return true;

        int nrow = 0, ncol = 0;
        if(col == 8) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if(board[row][col] != '.') {
            return solver(nrow, ncol, board);
        } else {
            for(int i = 1; i <= 9; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');
                    if(solver(nrow, ncol, board)) return true;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, int num) {
        char n = (char)(num + '0');

        for(int i=0; i<9; i++) {
            if(board[row][i] == n) return false;
        }

        for(int i=0; i<9; i++) {
            if(board[i][col] == n) return false;
        }

        int cr = 3 * (row/3);
        int cc = 3 * (col/3);

        for(int i=cr; i<cr+3; i++) {
            for(int j=cc; j<cc+3; j++) {
                if(board[i][j] == n) return false;
            }
        }
        return true;
    }
}
