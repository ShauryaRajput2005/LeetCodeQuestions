# Last updated: 8/4/2025, 5:58:24 PM
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack=[]
        balance=0
        result=""
    
        for char in s:
            if char == '(':
                stack.append('(')
                balance += 1
            elif char == ')':
                if balance > 0:
                    stack.append(')')
                    balance -= 1
            else:
                stack.append(char)

        while stack:
            char=stack.pop()
            if char=="(" and balance >0:
                balance-=1
            else:
                result=char+result
        return result
        