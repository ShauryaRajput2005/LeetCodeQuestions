class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] res=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],-1);
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    res[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] d:dir){
                int r=d[0]+cur[0];
                int c=d[1]+cur[1];
                if(c>=0 && r>=0 && c<m && r<n && res[r][c]==-1){
                    res[r][c]=1+res[cur[0]][cur[1]];
                    q.offer(new int[]{r,c});
                }
            }
        }
        return res;
    }
}