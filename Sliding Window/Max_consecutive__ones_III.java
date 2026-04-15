/* 
1004. Max Consecutive Ones III

# Problem Statement:
Given a binary array `nums` and an integer `k`, return the maximum number 
of consecutive 1's in the array if you can flip at most `k` 0's.

------------------------------------------------------------

# Intuition:
We want the longest subarray containing only 1's, but we are allowed 
to flip at most `k` zeros.

- Treat zeros as "allowed mistakes"
- We can have at most `k` zeros in our window

👉 So the problem becomes:
Find the longest subarray with at most `k` zeros.

------------------------------------------------------------

# Approach (Sliding Window):
- Use two pointers (left and right)
- Expand window by moving `right`
- Count zeros in the window
- If zeros exceed `k`, shrink window from left
- Track maximum window size

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------------------

# Example:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2  
Output: 6  

Explanation:
We can flip at most 2 zeros, so the longest valid subarray has length 6.

------------------------------------------------------------

🔥 Pattern: Sliding Window (At most K zeros)

------------------------------------------------------------
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}