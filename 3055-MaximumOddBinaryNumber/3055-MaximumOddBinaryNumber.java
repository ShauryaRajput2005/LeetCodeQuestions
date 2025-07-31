// Last updated: 7/31/2025, 10:34:38 PM
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                ones++;
            }
        }
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int l=0;
        while(l<n && ones>1){
            sb.append('1');
            ones--;
            l++;
        }
        while(l<n-1){
            sb.append('0');
            l++;
        }
        sb.append('1');
        return sb.toString();
    }
}