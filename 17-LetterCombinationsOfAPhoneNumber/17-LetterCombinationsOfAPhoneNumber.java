// Last updated: 8/4/2025, 6:02:14 PM
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        combination(digits,"",result);
        return result;        
    }
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void combination(String ques,String ans, List<String> result ){
        if(ques.length()==0){
            result.add(ans);
            return;
        }
        char cur= ques.charAt(0);
        String keyword=key[cur-'0'];
        for(int i=0;i<keyword.length();i++){
            combination(ques.substring(1),ans+keyword.charAt(i),result);
        }
    }
}