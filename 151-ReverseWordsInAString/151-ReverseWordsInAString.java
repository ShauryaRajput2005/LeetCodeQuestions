// Last updated: 8/4/2025, 6:00:49 PM
class Solution {
    public String reverseWords(String s) {
		s=s.trim();
		String [] arr=s.split("\s+");
		String result="";
		for(int i=arr.length-1;i>=0;i--) {
			result+=arr[i]+" ";
		}
		result=result.trim();
		return result;
		
	}

}
