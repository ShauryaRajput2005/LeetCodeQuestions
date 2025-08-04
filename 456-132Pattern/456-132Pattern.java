// Last updated: 8/4/2025, 5:59:35 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>();

        int n=nums.length;
        int third=Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            if(nums[i]<third){
                return true;
            }
            while(!stack.isEmpty() && nums[i]> stack.peek()){
                third=stack.pop();
            }
            stack.push(nums[i]);
        }
    return false;
    }
}