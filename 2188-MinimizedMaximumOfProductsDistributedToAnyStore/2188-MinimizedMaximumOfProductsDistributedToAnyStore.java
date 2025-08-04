// Last updated: 8/4/2025, 5:57:40 PM
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
    int left = 1, right = Arrays.stream(quantities).max().getAsInt();
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (isFeasible(mid, n, quantities)) {
            right = mid; // Try for a smaller maximum
        } else {
            left = mid + 1; // Increase the maximum
        }
    }
    
    return left;
}

private boolean isFeasible(int x, int n, int[] quantities) {
    int requiredStores = 0;
    
    for (int quantity : quantities) {
        requiredStores += (quantity + x - 1) / x;
    }
    
    return requiredStores <= n;
}

}