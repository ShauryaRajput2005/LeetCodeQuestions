// Last updated: 8/4/2025, 6:00:01 PM
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
         int[] freq =new int[n];
         for(int i=0;i<n;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]>1){
                return nums[i];
            }
         }
         return 0;
    }
}