// Last updated: 8/4/2025, 5:58:08 PM
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
     
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;
        
        
        for (String word : words) {
            if (isConsistent(allowedSet, word)) {
                count++; 
            }
        }
        
        return count;
    }
    
    
    public boolean isConsistent(Set<Character> allowedSet, String word) {
        for (char c : word.toCharArray()) {
            if (!allowedSet.contains(c)) {
                return false;  
            }
        }
        return true;  
    }
}
