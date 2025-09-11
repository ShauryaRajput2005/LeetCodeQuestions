// Last updated: 9/11/2025, 9:56:54 PM
import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Collect vowels
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Sort vowels
        Collections.sort(vowels);

        // Replace vowels in original string with sorted vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
