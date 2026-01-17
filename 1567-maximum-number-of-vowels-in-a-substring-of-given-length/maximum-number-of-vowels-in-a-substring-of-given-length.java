class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0, max = 0;
        String vowels = "aeiou";

        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) cnt++;
        }
        max = cnt;

        
        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) cnt++;          
            if (vowels.indexOf(s.charAt(i - k)) != -1) cnt--;      
            max = Math.max(max, cnt);
        }

        return max;
    }
}
