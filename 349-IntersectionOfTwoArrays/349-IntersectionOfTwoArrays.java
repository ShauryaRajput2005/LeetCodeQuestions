// Last updated: 8/4/2025, 5:59:53 PM
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[Math.min(m, n)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (index == 0 || result[index - 1] != nums1[i]) {
                    result[index++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}