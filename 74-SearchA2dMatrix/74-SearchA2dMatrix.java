// Last updated: 8/4/2025, 6:01:18 PM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        while(row>=0){
            for(int i=0;i<=col;i++){
                if(matrix[row][i]==target){
                    return true;
                }
            }
            row--;
        }
        return false;
    }
}