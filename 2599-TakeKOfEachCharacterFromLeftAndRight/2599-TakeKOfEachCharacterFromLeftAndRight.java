// Last updated: 7/31/2025, 10:34:51 PM
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] total = new int[3];
        for (char c : s.toCharArray()) {
            total[c - 'a']++;
        }

        // If any character appears less than k times, it's impossible
        if (total[0] < k || total[1] < k || total[2] < k) return -1;

        int maxWindow = 0;
        int[] count = new int[3];
        int left = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > total[0] - k || count[1] > total[1] - k || count[2] > total[2] - k) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
