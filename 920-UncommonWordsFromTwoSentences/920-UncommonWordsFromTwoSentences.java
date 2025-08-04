// Last updated: 8/4/2025, 5:58:52 PM
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        for (String word : arr1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (String word : arr2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        ArrayList<String> uncommonWords = new ArrayList<>();
        
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        
        return uncommonWords.toArray(new String[0]);
    }
}
