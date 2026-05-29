class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(val(nums[i]),min);
        }
        return min;
    }

    public int val(int n){
        int sum=0;
        int t=n;
        while(t>0){
            int d=t%10;
            sum+=d;
            t/=10;
        }
        return sum;
    }
}