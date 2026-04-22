/* 
876. Middle of the Linked List

# Problem Statement:
Given the head of a singly linked list, return the middle node 
of the linked list.

If there are two middle nodes, return the second middle node.

------------------------------------------------------------

# Intuition:
We need to find the middle node in one pass.

👉 Idea:
Use two pointers:
- Slow pointer moves 1 step
- Fast pointer moves 2 steps

By the time fast reaches the end:
👉 Slow will be at the middle

------------------------------------------------------------

# Approach (Two Pointers):
- Initialize slow and fast pointers at head
- Move slow by 1 step and fast by 2 steps
- When fast reaches null, slow is at the middle
- Return slow

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------------------

# Example:
Input: head = [1,2,3,4,5]  
Output: [3,4,5]  

Explanation:
Middle node is 3

------------------------------------------------------------

🔥 Pattern: Two Pointers (Fast & Slow)

------------------------------------------------------------
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps
        }

        return slow;  // middle node
    }
}