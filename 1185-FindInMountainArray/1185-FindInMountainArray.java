// Last updated: 8/4/2025, 5:58:32 PM
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the peak index
        int left = 0, right = n - 1, peak = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        peak = left;

        // Step 2: Binary search in ascending part (0 to peak)
        int leftResult = search(target, mountainArr, 0, peak, true);
        if (leftResult != -1) return leftResult;

        // Step 3: Binary search in descending part (peak + 1 to end)
        return search(target, mountainArr, peak + 1, n - 1, false);
    }

    public int search(int target, MountainArray mountainArr, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = mountainArr.get(mid);

            if (cur == target) return mid;

            if (ascending) {
                if (cur < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (cur > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
