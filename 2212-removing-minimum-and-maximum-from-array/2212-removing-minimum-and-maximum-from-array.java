class Solution {
    public int minimumDeletions(int[] nums) {
        int minidx=-1 , min=Integer.MAX_VALUE;
        int maxidx=-1 , max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                minidx=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxidx=i;
            }
        }
        int fm=Math.max(minidx,maxidx)+1;
        int bm=n-Math.min(minidx,maxidx);
        int tm=Math.min(minidx,maxidx)+(n-Math.max(minidx,maxidx))+1;
        return Math.min(tm,Math.min(bm,fm));
    }
}