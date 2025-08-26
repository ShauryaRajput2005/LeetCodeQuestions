class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonalSq = 0;
        
        for (int i = 0; i < dimensions.length; i++) {
            int w = dimensions[i][0];
            int h = dimensions[i][1];
            int diagonalSq = w * w + h * h; 
            int area = w * h;
            
            if (diagonalSq > maxDiagonalSq || 
               (diagonalSq == maxDiagonalSq && area > maxArea)) {
                maxDiagonalSq = diagonalSq;
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
