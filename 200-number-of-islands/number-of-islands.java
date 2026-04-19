class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1') {
                    bfs(grid,i,j);
                    cnt++;
                }
            }
        }
    return cnt;
    }

    public static void bfs(char[][] grid,int r,int c){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] d:dir){
                int nr=d[0]+cur[0];
                int nc=d[1]+cur[1];
                if(nr>=0 && nc>=0 && nc<grid[0].length && nr<grid.length && grid[nr][nc]=='1'){
                    grid[nr][nc]='0';
                    q.offer(new int[]{nr,nc});
                }
            }

        } 
    }
}
  
