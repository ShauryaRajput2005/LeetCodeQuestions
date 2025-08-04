// Last updated: 8/4/2025, 6:02:15 PM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int lo=i+1;
            int hi=nums.length-1;

            while(lo<hi){
                
                if(nums[i]+nums[lo]+nums[hi]==0){
                
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                
                    while(hi>lo && nums[hi]==nums[hi-1]) hi--;

                    lo++;
                    hi--;
                
                }else if(nums[i] +nums[lo]+nums[hi]<0){
                    lo++;
                }else{
                    hi--;
                }

           
            }
        }
        return result;
        
    }
}