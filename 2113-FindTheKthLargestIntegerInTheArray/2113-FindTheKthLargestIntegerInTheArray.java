// Last updated: 8/4/2025, 5:57:48 PM
import java.util.Arrays;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); // longer number is larger
            }
            return b.compareTo(a); // lexicographic comparison
        });
        return nums[k - 1];
    }
}
