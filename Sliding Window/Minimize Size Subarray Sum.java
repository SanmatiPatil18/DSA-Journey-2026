/*209 Minimize Size SubArray Sum

#Problem Statment :Given an array of positive integers nums and a 
positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.


# Intuition
    Since all elements are positive, we can use a sliding window approach.
We expand the window to reach a sum ≥ target, and then shrink it from the left
 to minimize the length. This ensures we find the smallest valid subarray efficiently.

# Approach
-- - Use two pointers (`left` and `right`)
- Expand window by adding elements
- Shrink window when sum ≥ target
- Track minimum length 

# Complexity
- Time complexity:
    O(n)

- Space complexity:
    O(1) */

# Code

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left = 0;
        int sum= 0;
        int minLen=Integer.MAX_VALUE;

        for(int right=0 ; right <n ; right++)
        {
            sum+=nums[right];
        
        while(sum>=target)
        {
            minLen=Math.min(minLen,right-left+1);
        sum-=nums[left];
        left++ ;
        }
        }
         return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
             
        
    }
}

