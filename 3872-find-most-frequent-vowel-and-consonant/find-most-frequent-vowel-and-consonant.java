class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        String vowels="aeiou";
        int vow=0,cons=0;

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                char c=(char) (i+'a');
                if(vowels.indexOf(c)>=0){
                    vow=Math.max(vow,freq[i]);
                }else{
                    cons=Math.max(freq[i],cons);
                }
            }
        }
        return vow+cons;
        
    }
}