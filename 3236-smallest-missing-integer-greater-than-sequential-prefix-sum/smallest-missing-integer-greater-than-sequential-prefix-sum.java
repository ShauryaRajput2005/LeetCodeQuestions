class Solution {
    public int missingInteger(int[] nums) {
        int cur=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                cur+=nums[i];
            }else{
                break;
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums ){
            set.add(num);
        }
        while(set.contains(cur)){
            cur++;
        }
        return cur;
    }
}