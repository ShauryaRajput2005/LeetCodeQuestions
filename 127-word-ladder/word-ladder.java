class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordset = new HashSet<>(wordList);

        if(!wordset.contains(endWord)) return 0;

        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int level=1;
        

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();

                char[] wordChars=word.toCharArray();
                for(int j=0;j<wordChars.length;j++){
                    char orignal=wordChars[j];

                    for(char c='a';c<='z';c++ ){
                        if(wordChars[j]==c) continue;
                        wordChars[j]=c;
                        String newWord=new String(wordChars);
                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                        if(wordset.contains(newWord)){
                            q.add(newWord);
                            wordset.remove(newWord);
                        }
                    
                    }
                    wordChars[j]=orignal;
                }
            }
        level++;
        }
return 0;

    }
}