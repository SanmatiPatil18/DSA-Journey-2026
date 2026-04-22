/* 
141. Linked List Cycle

# Problem Statement:
Given the head of a linked list, determine if the linked list has a cycle.

A cycle exists if some node can be reached again by continuously 
following the next pointer.

Return true if there is a cycle, otherwise return false.

------------------------------------------------------------

# Intuition:
If there is a cycle, we will keep visiting the same nodes again.

👉 Idea:
Use two pointers:
- Slow pointer moves 1 step
- Fast pointer moves 2 steps

If a cycle exists:
- Fast will eventually meet slow

If no cycle:
- Fast will reach null

------------------------------------------------------------

# Approach (Floyd’s Cycle Detection - Two Pointers):
- Initialize slow and fast pointers at head
- Move slow by 1 step and fast by 2 steps
- If they meet → cycle exists
- If fast reaches null → no cycle

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------------------

# Example:
Input: head = [3,2,0,-4], pos = 1  
Output: true  

Explanation:
Tail connects back to node at index 1 → cycle exists

------------------------------------------------------------

🔥 Pattern: Two Pointers (Fast & Slow)

------------------------------------------------------------
*/

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                return true;           // cycle detected
            }
        }

        return false;                  // no cycle
    }
}