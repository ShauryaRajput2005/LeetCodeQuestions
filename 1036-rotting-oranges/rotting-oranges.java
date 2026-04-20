class Solution {

    public int orangesRotting(int[][] grid) {
        int fr=0;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fr++;
            }
        }
    
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
             boolean rotting = false;
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dir) {
                    int nr = d[0] + cur[0];
                    int nc = d[1] + cur[1];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fr--;
                        q.offer(new int[] { nr, nc });
                        rotting=true;
                    }
                }
            }
            if(rotting) cnt++;

        }
        return (fr>0) ? -1 :cnt; 
    }
}