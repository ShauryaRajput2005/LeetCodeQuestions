
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int pos = Arrays.binarySearch(sub, 0, len, num);
            if (pos < 0) pos = -(pos + 1);
            sub[pos] = num;
            if (pos == len) len++;
        }
        return len;
    }
}
