// Last updated: 8/4/2025, 6:01:42 PM
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);  
        reverse(matrix);
    }
    public static void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public static void reverse(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
        int left=0;
        int right=matrix[0].length-1;
            while(left<right){
                matrix[i][left]=matrix[i][left]+matrix[i][right];
                matrix[i][right]=matrix[i][left]-matrix[i][right];
                matrix[i][left]=matrix[i][left]-matrix[i][right];
            left++;
            right--;
            }
        }
    }
}