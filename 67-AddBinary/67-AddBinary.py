# Last updated: 8/4/2025, 6:01:24 PM
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a,2)+int(b,2))[2:]