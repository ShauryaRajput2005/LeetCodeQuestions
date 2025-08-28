// Last updated: 8/28/2025, 9:53:36 PM
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;
        int cnt = 0;
        boolean up = true;

        while (cnt < m * n) {
            result[cnt] = mat[row][col];
            cnt++;

            if (up) {
                if (col == n - 1) {       
                    row++;
                    up = false;
                } else if (row == 0) {    
                    col++;
                    up = false;
                } else {                  
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {      
                    col++;
                    up = true;
                } else if (col == 0) {   
                    row++;
                    up = true;
                } else {                 
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
