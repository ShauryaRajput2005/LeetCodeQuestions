class Solution {
    public int minOperations(String s) {
        int ch1=0;
        char cur='0';
        for(char c:s.toCharArray()){
            if(cur!=c){
                ch1++;
            }
            cur=(cur=='0') ? '1':'0';
        }
        cur='1';
        int ch2=0;
        for(char c:s.toCharArray()){
            if(cur!=c){
                ch2++;
            }
            cur=(cur=='0') ? '1':'0';
        }
        return Math.min(ch2,ch1);
    }
}