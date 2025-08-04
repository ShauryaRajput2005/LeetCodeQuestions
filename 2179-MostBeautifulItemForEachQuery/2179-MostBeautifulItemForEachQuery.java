// Last updated: 8/4/2025, 5:57:41 PM
import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int index = binarySearch(items, target);
            ans[i] = (index == -1) ? 0 : maxBeauty[index];
        }
        
        return ans;
    }
    
    private int binarySearch(int[][] items, int target) {
        int lo = 0, hi = items.length - 1;
        int bestIndex = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (items[mid][0] <= target) {
                bestIndex = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return bestIndex;
    }
}
