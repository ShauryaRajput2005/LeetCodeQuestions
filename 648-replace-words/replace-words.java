class Solution {

    class Trie {

        class Node {
            boolean isTerminal;
            HashMap<Character, Node> child = new HashMap<>();
        }

        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node());
                curr = curr.child.get(ch);
            }
            curr.isTerminal = true;
        }

        String getRoot(String word) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                if (!curr.child.containsKey(ch)) break;

                curr = curr.child.get(ch);
                sb.append(ch);

                if (curr.isTerminal) {
                    return sb.toString();
                }
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String root : dictionary) {
            trie.insert(root);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            result.append(trie.getRoot(word)).append(" ");
        }

        return result.toString().trim();
    }
}
