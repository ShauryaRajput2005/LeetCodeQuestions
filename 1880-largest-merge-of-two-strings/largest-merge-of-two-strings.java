class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        int n = word1.length();
        int m = word2.length();

        while (i < n && j < m) {
            char a = word1.charAt(i);
            char b = word2.charAt(j);

            if (a > b) {
                str.append(a);
                i++;
            } else if (b > a) {
                str.append(b);
                j++;
            } else {
                String sub1 = word1.substring(i, n);
                String sub2 = word2.substring(j, m);
                if (sub1.compareTo(sub2)>0) {
                    str.append(a);
                    i++;
                } else {
                    str.append(b);
                    j++;
                }
            }
        }
        while (i < n) {
            str.append(word1.charAt(i));
            i++;
        }

        while (j < m) {
            str.append(word2.charAt(j));
            j++;
        }
        return str.toString();
    }
}