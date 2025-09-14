class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
      Set<String> exact = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            capMap.putIfAbsent(lower, word);

            String pattern = devowel(lower);
            vowelMap.putIfAbsent(pattern, word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (capMap.containsKey(lower)) {
                    ans[i] = capMap.get(lower);
                } else {
                    String pattern = devowel(lower);
                    ans[i] = vowelMap.getOrDefault(pattern, "");
                }
            }
        }
        return ans;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}