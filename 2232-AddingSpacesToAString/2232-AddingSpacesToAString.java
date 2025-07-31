// Last updated: 7/31/2025, 10:35:14 PM
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int sp=0;
        for(int i=0;i<s.length();i++){
            if(sp< spaces.length && spaces[sp]==i){
                sb.append(' ');
                sp++;
            }
            sb.append(s.charAt(i));
        } 
        return sb.toString();
    }
}