class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxh = 1;
        int maxv = 1;
        int cnth = 1;
        int cntv = 1;

        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i + 1] - hBars[i] == 1) {
                cnth++;
            } else {
                cnth = 1;
            }
            maxh = Math.max(maxh, cnth);
        }

        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i + 1] - vBars[i] == 1) {
                cntv++;
            } else {
                cntv = 1;
            }
            maxv = Math.max(maxv, cntv);
        }

        int side = Math.min(maxh + 1, maxv + 1);
        return side * side;
    }
}