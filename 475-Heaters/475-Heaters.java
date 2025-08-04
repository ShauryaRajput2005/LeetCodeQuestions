// Last updated: 8/4/2025, 5:59:34 PM
import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0;
        int right = (int) 1e9; 
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isRadiusSufficient(houses, heaters, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isRadiusSufficient(int[] houses, int[] heaters, int rad) {
        int i = 0; // pointer for heaters

        for (int house : houses) {
            // move to nearest heater
            while (i < heaters.length - 1 &&
                   Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }

            int dist = Math.abs(heaters[i] - house);
            if (dist > rad) return false;
        }

        return true;
    }
}
