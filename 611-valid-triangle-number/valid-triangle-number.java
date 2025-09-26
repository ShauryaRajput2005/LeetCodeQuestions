class Solution {
    public int triangleNumber(int[] nums) {
        int cnt=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int k=i+2;
            for(int j=i+1;nums[i]>0 && j<nums.length;j++){
                 
                while(k<nums.length && nums[k]<nums[i]+nums[j]){
                    k++;
                    cnt+=k-j-1;
                }
            }
        }       
        return cnt; 
    }
}