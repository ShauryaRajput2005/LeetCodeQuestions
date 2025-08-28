// Last updated: 8/28/2025, 9:52:53 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int cnt = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } 

            while(cnt>1){
                if(nums[left]==0){
                    cnt--;
                }
                left++;
            }
            len=Math.max(len,i-left);
        }
        return len;
    }
}