/*
LeetCode 83 - Remove Duplicates from Sorted List
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Pattern: Two Pointers (Linked List)
Difficulty: Easy

Problem:
Given the head of a sorted linked list, delete all duplicates such that
each element appears only once.

Approach:
- Use two pointers on the linked list
- Current pointer compares its value with next node
- If duplicate, skip the next node
- Otherwise, move forward

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* curr=head;
        while(curr!=NULL && curr->next!=NULL)
        {
            if (curr->val == curr->next->val)
            {
                curr->next = curr->next->next;
            }
            else
            {
            curr=curr->next;
        }
        }   return head;
    }

   
};

