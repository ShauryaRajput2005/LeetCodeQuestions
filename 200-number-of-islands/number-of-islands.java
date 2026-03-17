class Solution {
    public int numIslands(char[][] grid) {
     int cnt = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        sink(grid, i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        public static void sink(char[][] grid, int row, int col) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
                return;
            }
            grid[row][col] = '0';
            sink(grid, row + 1, col);
            sink(grid, row - 1, col);
            sink(grid, row, col + 1);
            sink(grid, row, col - 1);
        }
    }

  
