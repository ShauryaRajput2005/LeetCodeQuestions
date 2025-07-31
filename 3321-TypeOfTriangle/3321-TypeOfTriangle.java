// Last updated: 7/31/2025, 10:34:32 PM
class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(!IsPossible(nums)){
            return "none";
        }
        if(nums[0]==nums[1] && nums[1]==nums[2]){
            return "equilateral";
        }else if(nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2]){
            return "isosceles";
        }
    return "scalene";
    }

    public static boolean IsPossible(int[] nums){
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        if(a+b<=c){
            return false;
        }
        return true;
    }
}