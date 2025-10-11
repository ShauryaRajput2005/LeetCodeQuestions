// Last updated: 10/11/2025, 8:08:43 PM
class Solution {
    public boolean scoreBalance(String s) {
        int score=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            score+=ch-'a'+1;
        }
        int cur =0;
        for(int i =0;i<s.length()-1;i++){
            char ch=s.charAt(i);
            cur+=ch-'a'+1;
            if(cur*2==score){
                return true;
            }
        }
    return false;
    }
}