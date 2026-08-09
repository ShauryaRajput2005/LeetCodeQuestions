class Solution {
    static int[][][] memo;
    public int stoneGameII(int[] piles) {
        memo=new int[2][101][101];
        return game(1, 0, 1, piles);
    }

    public static int game(int m, int idx, int p, int[] piles) {
        if (idx >= piles.length) {
            return 0;
        }
        if(memo[p][idx][m]>0){
            return memo[p][idx][m];
        }
        int sum = 0;
        int res = (p == 1) ? -1 : Integer.MAX_VALUE;

        for (int i = 1; i <= 2 * m && idx + i <= piles.length; i++) {
            sum += piles[idx + i - 1];

            if (p == 1) {
                res = Math.max(
                    res,
                    sum + game(Math.max(i, m), idx + i, 0, piles)
                );
            } else {
                res = Math.min(
                    res,
                    game(Math.max(i, m), idx + i, 1, piles)
                );
            }
        }
        memo[p][idx][m]=res;
        return res;
    }
}