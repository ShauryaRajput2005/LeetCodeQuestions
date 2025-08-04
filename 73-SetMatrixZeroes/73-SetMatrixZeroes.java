// Last updated: 8/4/2025, 6:01:20 PM
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean firstrow = false;
        boolean firstcol = false;

        // Step 1: Check if the first row has any zeroes
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstrow = true;
                break;
            }
        }

        // Step 2: Check if the first column has any zeroes
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstcol = true;
                break;
            }
        }

        // Step 3: Use the first row and column as markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark row
                    matrix[0][j] = 0;  // Mark column
                }
            }
        }

        // Step 4: Zero out cells based on markers in the first row and column
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero the first column if needed
        if (firstcol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

        // Step 6: Zero the first row if needed
        if (firstrow) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
