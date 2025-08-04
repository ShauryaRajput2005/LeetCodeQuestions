// Last updated: 8/4/2025, 6:01:14 PM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        subsets(nums,0,ans,result);
        return result;
        
    }
    public static void subsets(int[] nums,int idx,List<Integer> ans ,List<List<Integer>> result){
        if(idx==nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        // element doesnt joins
        subsets(nums,idx+1,ans,result);    

        // element joins
        ans.add(nums[idx]);
        subsets(nums,idx+1,ans,result);
        ans.remove(ans.size()-1);
    }

}