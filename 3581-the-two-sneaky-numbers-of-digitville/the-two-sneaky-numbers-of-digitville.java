class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int k=0;
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
           int idx=nums[i];
           if(nums[i]==i) continue;
           if(nums[idx]==idx && k<2){
            ans[k]=idx;
            k++;
            continue;
           }
           int temp=nums[idx];
           nums[idx]=idx;
           nums[i]=temp;
        }
    return ans;
    }
}