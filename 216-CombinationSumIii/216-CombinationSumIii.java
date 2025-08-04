// Last updated: 8/4/2025, 6:00:19 PM
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        summ(k,n,result,ans,1);
        return result;
    }

    public static void summ(int k,int n, List<List<Integer>> result, List<Integer> ans,int idx){
        if (n==0 && k==0){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=idx;i<=9;i++){
            if(n>=i){
                ans.add(i);
                summ(k-1,n-i,result,ans,i+1);
                ans.remove(ans.size() - 1); 
            }
        }
    }
}
