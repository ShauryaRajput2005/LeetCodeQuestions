# Last updated: 8/4/2025, 6:02:25 PM
class Solution:
    def isPalindrome(self, x: int) -> bool:
        x=str(x)
        if x==x[::-1]:
            return True
        else:
            False
        