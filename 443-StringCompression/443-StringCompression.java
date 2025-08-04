// Last updated: 8/4/2025, 5:59:38 PM
class Solution {
    public int compress(char[] chars) {
        if(chars.length<2){
            return chars.length;
        }
        int idx=0;
        for(int i=0;i<chars.length;i++){
            char cur=chars[i];
            int cnt=0;
            while(i<chars.length && cur==chars[i]){
                i++;
                cnt++;
            }
            if(cnt==1){
                chars[idx++]=cur;
            }else{
                chars[idx++]=cur;
                for(char digit : Integer.toString(cnt).toCharArray()){
                    chars[idx++]=digit;
                }
            }
            i--;
        
        }
        return idx;
    }
}