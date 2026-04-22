class Solution {

    static class TrieNode{
        TrieNode[] child=new TrieNode[26];
        boolean eow=false;
    }

    TrieNode root=new TrieNode();

    public void insert(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(node.child[i]==null){
                node.child[i]=new TrieNode();
            }
            node=node.child[i];
        }
        node.eow=true;
    }

    public static boolean dfs(TrieNode node,String word,int idx,int edits){
        if(edits>2) return false;
        if(idx==word.length()) return true;

        int cur=word.charAt(idx)-'a';

        for(int i=0;i<26;i++){
            if(node.child[i]==null) continue;

            if(i==cur){
                if(dfs(node.child[i],word,idx+1,edits)){
                    return true;
                }
            }else{
                if(dfs(node.child[i],word,idx+1,edits+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        for(String d:dictionary){
            insert(d);
        }
        List<String> res=new ArrayList<>();
        for(String q:queries){
            if(dfs(root,q,0,0)){
                res.add(q);
            }
        }
        return res;
    }
}