// Last updated: 8/4/2025, 6:00:00 PM
import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                int live = check(copy, i, j);

                if (copy[i][j] == 0 && live == 3) {
                    board[i][j] = 1;  // dead -> live
                } else if (copy[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;  // live -> dead
                    }
                }
            }
        }
    }

    public static int check(int[][] board, int row, int col) {
        int live = 0;
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0}, {1, 1}
        };

        int m = board.length;
        int n = board[0].length;

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 1) {
                live++;
            }
        }

        return live;
    }
}
