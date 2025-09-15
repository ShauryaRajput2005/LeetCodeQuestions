class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> charSet = new HashSet<>();
        char[] charArray = brokenLetters.toCharArray();
        for (char c : charArray) {
            charSet.add(c);
        }
        int cnt=0;
        String[] words = text.split(" ");
        for(String str:words){
            for(char ch:str.toCharArray()){
                if(charSet.contains(ch)){
                    cnt++;
                    break;
                }
            }
        }
    return words.length-cnt;
    }
}