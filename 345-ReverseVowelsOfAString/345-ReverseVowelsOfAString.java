// Last updated: 8/4/2025, 5:59:55 PM
class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] ar = s.toCharArray();

        HashSet<Character> set = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while (left < right) {
            while (left < right && !set.contains(ar[left])) {
                left++;
            }
            while (left < right &&!set.contains(ar[right])) {
                right--;
            }
            char temp = ar[left];
            ar[left] = ar[right];
            ar[right] = temp;
            right--;
            left++;
        }
        return String.valueOf(ar);
    }
}