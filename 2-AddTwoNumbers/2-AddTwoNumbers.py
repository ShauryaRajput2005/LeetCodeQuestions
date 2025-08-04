# Last updated: 8/4/2025, 6:02:40 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # Initialize empty lists to store the values of l1 and l2
        a = []
        b = []

        # Traverse the linked lists l1 and l2 and append their values to lists a and b
        current = l1
        while current:
            a.append(str(current.val))
            current = current.next

        current = l2
        while current:
            b.append(str(current.val))
            current = current.next

        # Convert the lists of values to integers
        a = int("".join(a[::-1]))
        b = int("".join(b[::-1]))

        # Calculate the sum of a and b
        result = str(a + b)

        # Create a new linked list to store the result
        dummy = ListNode()
        current = dummy

        # Populate the result linked list with digits from the sum in reverse order
        for digit in result[::-1]:
            current.next = ListNode(int(digit))
            current = current.next

        # Return the next node of dummy, which is the head of the result linked list
        return dummy.next
