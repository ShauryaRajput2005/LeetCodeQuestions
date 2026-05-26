class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower=new int[26];
        int[] upper=new int[26];
        int cnt=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                lower[ch-'a']++;
            }else{
                upper[ch-'A']++;
            }
        }

        for(int i=0;i<26;i++){
            if(upper[i]>0 && lower[i]>0){
                cnt++;
            }
        }
        return cnt;
    }
}