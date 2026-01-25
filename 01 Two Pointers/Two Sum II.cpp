/*
LeetCode 167 - Two Sum II (Input Array Is Sorted)
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Pattern: Two Pointers
Difficulty: Easy

Problem:
Given a 1-indexed sorted array of integers, find two numbers such that
they add up to a specific target number and return their indices.

Approach:
- Use two pointers: one at the start, one at the end
- If sum is less than target, move left pointer
- If sum is greater than target, move right pointer
- Since the array is sorted, this works efficiently

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because the array is 1-indexed
                return {left + 1, right + 1};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return {}; // guaranteed one solution
    }
};
