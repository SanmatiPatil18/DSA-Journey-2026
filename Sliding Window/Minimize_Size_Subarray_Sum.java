/* 
209. Minimum Size Subarray Sum

# Problem Statement:
Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.

------------------------------------------------------------

# Intuition:
Since all elements are positive, we can use a sliding window approach.

- Expanding the window increases the sum
- Shrinking the window decreases the sum

So:
1. Expand the window until sum ≥ target
2. Then shrink it from the left to find the minimum length

------------------------------------------------------------

# Approach (Sliding Window):
- Use two pointers (left and right)
- Expand window by adding elements (sum += nums[right])
- When sum ≥ target, shrink window from left
- Update minimum length during shrinking

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------------------

# Example:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2

Explanation:
The subarray [4,3] has the smallest length = 2

------------------------------------------------------------

🔥 Pattern: Sliding Window (Minimum Length Subarray)

------------------------------------------------------------
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}