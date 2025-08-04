// Last updated: 8/4/2025, 6:01:50 PM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(candidates);
        summ(candidates,target,result,ans,0);
        
        return result;
    }

    public static void summ(int[] nums,int tar, List<List<Integer>> result, List<Integer> ans,int idx){
        if (tar==0){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if (i > idx && nums[i] == nums[i - 1]) continue;

            if(tar>=nums[i]){
                ans.add(nums[i]);
                summ(nums,tar-nums[i],result,ans,i+1);
                ans.remove(ans.size() - 1); 
            }
        }
    }
}
