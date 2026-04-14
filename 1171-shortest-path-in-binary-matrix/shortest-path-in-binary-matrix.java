class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]>q=new LinkedList();
        q.offer(new int[]{0,0,1});
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        grid[0][0]=1;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if (cur[0] == n-1 && cur[1] == n-1) return grid[n-1][m-1];
            for(int[] d:dir){
                int r=cur[0]+d[0];
                int c=cur[1]+d[1];
                if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==0){
                    grid[r][c]=grid[cur[0]][cur[1]]+1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return -1;
    }
}