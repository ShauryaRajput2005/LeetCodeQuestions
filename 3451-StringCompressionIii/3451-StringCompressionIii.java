// Last updated: 7/31/2025, 10:34:20 PM
class Solution {
    public String compressedString(String word) {
        StringBuilder str=new StringBuilder();
        int cnt=1;
        char cur=word.charAt(0);
        for(int i=1;i<word.length();i++){
            if(cur==word.charAt(i) && cnt<9){
                cnt++;
            }else{
                str.append(cnt).append(cur);
                cur=word.charAt(i);
                cnt=1;
            }
        }
        str.append(cnt).append(cur);
        return str.toString();
    }
}