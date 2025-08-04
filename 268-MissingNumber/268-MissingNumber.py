# Last updated: 8/4/2025, 6:00:06 PM
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        for i in range(0,n+1):
            if i not in nums:
                return i