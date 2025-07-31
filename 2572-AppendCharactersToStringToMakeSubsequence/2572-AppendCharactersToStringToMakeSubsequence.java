// Last updated: 7/31/2025, 10:34:55 PM
class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                j++;
            }
            i++;
        }
    return t.length()-j;
    }
}