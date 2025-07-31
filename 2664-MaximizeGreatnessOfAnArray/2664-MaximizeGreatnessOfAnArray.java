// Last updated: 7/31/2025, 10:34:48 PM
import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int greatness = 0;
        int i = 0; 

        for (int j = 0; j < n; j++) { 
            if (nums[i] < nums[j]) {
                greatness++;
                i++;
            }
        }
        
        return greatness;
    }
}
