class Solution {
    int[][][] d = {
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };

    public boolean hasValidPath(int[][] g) {
        int m = g.length, n = g[0].length;
        boolean[][] vis = new boolean[m][n];
        return dfs(0,0,g,vis,m,n);
    }

    private boolean dfs(int x,int y,int[][] g,boolean[][] vis,int m,int n){
        if(x==m-1 && y==n-1) return true;
        vis[x][y] = true;

        for(int[] dir : d[g[x][y]]){
            int nx = x + dir[0], ny = y + dir[1];
            if(nx<0||ny<0||nx>=m||ny>=n||vis[nx][ny]) continue;

            for(int[] back : d[g[nx][ny]]){
                if(nx+back[0]==x && ny+back[1]==y){
                    if(dfs(nx,ny,g,vis,m,n)) return true;
                }
            }
        }
        return false;
    }
}