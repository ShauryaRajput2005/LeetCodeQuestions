class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt=0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        int t=0;
        boolean rot=false;
        while(!q.isEmpty()){
            int size=q.size();

            rot=false;
            while(size-->0){
                int[] cur=q.poll();
                for(int i=0;i<4;i++){
                    int nr=cur[0] + dir[i][0];
                    int nc=cur[1] + dir[i][1];
                    if(nr<0 || nc<0 || nr>=n || nc>=m ){
                        continue;
                    }
                    if(grid[nr][nc]!=1) continue;
                    grid[nr][nc]=2;
                    rot=true;
                    cnt--;
                    q.offer(new int[]{nr,nc});
                }
            }
            if(rot) t++;
        }
        return (cnt==0)? t:-1;
    }
}