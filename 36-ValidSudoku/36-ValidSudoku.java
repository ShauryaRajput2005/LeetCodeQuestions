// Last updated: 8/4/2025, 6:01:55 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] gridCheck = new boolean[9];

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rowCheck[num]) return false;
                    rowCheck[num] = true;
                }

                // Check column
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (colCheck[num]) return false;
                    colCheck[num] = true;
                }

                // Check 3x3 grid
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.') {
                    int num = board[rowIndex][colIndex] - '1';
                    if (gridCheck[num]) return false;
                    gridCheck[num] = true;
                }
            }
        }
        return true;
    }
}
