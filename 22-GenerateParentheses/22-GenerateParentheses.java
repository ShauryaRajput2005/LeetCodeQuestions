// Last updated: 8/4/2025, 6:02:08 PM
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        para(n,0,0,"",result);
        return result;
    }

    public static void para(int n,int open,int close,String ans,List<String> result) {
		if(open==n && close==n) {
			result.add(ans);
            return;
		}
		if(open>n || close >open) {
			return;
		}
		
		para(n,open+1,close,ans+"(",result);
		para(n,open,close+1,ans+")",result);
	}
}