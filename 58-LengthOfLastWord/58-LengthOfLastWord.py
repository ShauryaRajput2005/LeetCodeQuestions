# Last updated: 8/4/2025, 6:01:33 PM
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        lst=s.split()
        l=len(lst)
        result=len(lst[l-1])
        return result
        