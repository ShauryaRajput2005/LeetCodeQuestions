// Last updated: 8/4/2025, 6:01:15 PM
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
		List<Integer> ans=new ArrayList<>();
		combination(n,k,result,ans,1);
        return result;
    }
    public static void combination(int n,int k,List<List<Integer>> result,List<Integer> ans,int idx) {
		if(k==0) {
			result.add(new ArrayList<>(ans));
            return;
		}
		for(int i=idx;i<=n;i++) {

			// if element joins
			ans.add(i);
			combination(n,k-1,result,ans,i+1);
			ans.remove(ans.size()-1);
		}
	}
}