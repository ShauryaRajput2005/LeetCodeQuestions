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

    // Helper method to check if a character is a vowel (case-insensitive)
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
