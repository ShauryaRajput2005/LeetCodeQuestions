# Last updated: 8/4/2025, 6:01:25 PM
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        carry = 1
    
        for i in range(n - 1, -1, -1): # iterate from right to left
            digits[i] += carry
            carry = digits[i] // 10
            digits[i] %= 10
        
            if carry == 0:  # if no carry, we can stop
                break
    
        if carry == 1:  # if carry still exists, add 1 at the beginning
            digits.insert(0, 1)
    
        return digits