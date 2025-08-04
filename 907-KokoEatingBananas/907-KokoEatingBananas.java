// Last updated: 8/4/2025, 5:58:55 PM
import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min = 1;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, piles, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean check(int num, int[] arr, int h) {
        int cnt = 0;
        for (int k : arr) {
            cnt += (k + num - 1) / num;
            if (cnt > h) {
                return false;
            }
        }
        return true;
    }
}
