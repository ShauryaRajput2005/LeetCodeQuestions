// Last updated: 8/4/2025, 6:00:29 PM
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int[] ans = new int[n];
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (ans[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    ans[j] = 1;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (ans[i] == 0) count++;
        }
        return count;
    }
}
