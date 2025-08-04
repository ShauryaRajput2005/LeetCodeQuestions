# Last updated: 8/4/2025, 6:02:19 PM
class Solution:
    def romanToInt(self, s: str) -> int:
        roman={"I":1,"V":5,"X":10,"L":50,"C":100,"D":500, "M":1000}  
        sum=0
        prev_val=0
        for char in s:
            cur_val=roman[char]
            if cur_val>prev_val:
                sum=sum+(cur_val-2*prev_val)
            else:
                sum+=cur_val
            prev_val=cur_val
        return sum