// Last updated: 7/31/2025, 10:35:12 PM
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int size = (len + k - 1) / k; // ceil(len/k)
        String[] res = new String[size];
        
        int index = 0;
        for (int i = 0; i < len; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                if (i + j < len) {
                    sb.append(s.charAt(i + j));
                } else {
                    sb.append(fill);
                }
            }
            res[index++] = sb.toString();
        }
        
        return res;
    }
}
