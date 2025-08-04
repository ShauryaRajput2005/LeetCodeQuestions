// Last updated: 8/4/2025, 5:57:54 PM
class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int index = s.indexOf(part);  
            s = s.substring(0, index) + s.substring(index + part.length()); 
        }
        return s; 
    }
}