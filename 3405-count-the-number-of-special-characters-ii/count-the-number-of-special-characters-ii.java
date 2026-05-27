class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        Arrays.fill(freq1,-1);
        Arrays.fill(freq2,Integer.MAX_VALUE);

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                int k=ch-'a';
                freq1[k]=Math.max(i,freq1[k]);
            }else{
                int k=ch-'A';
                freq2[k]=Math.min(i,freq2[k]);
            }
        }
        int cnt=0;
        for(int i=0;i<26;i++){
            if(freq1[i]!=-1 && freq2[i]!=Integer.MAX_VALUE && freq2[i]>freq1[i]){
                cnt++;
            }
        }
        return cnt;
    }
}