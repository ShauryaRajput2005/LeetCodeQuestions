class Trie {

    class Node {
        Node[] child;
        boolean isTerminal;

        Node() {
            child = new Node[26];
            isTerminal = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }

            cur = cur.child[idx];
        }

        cur.isTerminal = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.child[idx] == null) {
                return false;
            }

            curr = curr.child[idx];
        }

        return curr.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for(int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if(curr.child[idx] == null) {
                return false;
            }

            curr = curr.child[idx];
        }

        return true;
    }
}