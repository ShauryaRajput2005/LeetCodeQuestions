# Last updated: 8/4/2025, 6:02:37 PM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        max_length = 0
        start = 0
        char_index_map = {}

        for i in range(len(s)):
            char = s[i]
            if char in char_index_map and char_index_map[char] >= start:
                start = char_index_map[char] + 1
            else:
                max_length = max(max_length, i - start + 1)
            char_index_map[char] = i

        return max_length