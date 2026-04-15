/* 
3. Longest Substring Without Repeating Characters

# Problem Statement:
Given a string `s`, find the length of the longest substring 
without repeating characters.

------------------------------------------------------------

# Intuition:
We need to find the longest substring with all unique characters.

- If a character repeats, we must shrink the window
- We use a sliding window to maintain unique characters

👉 Key Idea:
When we see a duplicate character, move the `left` pointer 
to the position right after the previous occurrence.

------------------------------------------------------------

# Approach (Sliding Window + HashMap):
- Use two pointers (left and right)
- Use a HashMap to store the last index of each character
- Expand window using `right`
- If duplicate found → move `left` to avoid repetition
- Update max length

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(n)

------------------------------------------------------------

# Example:
Input: s = "abcabcbb"
Output: 3

Explanation:
The answer is "abc", with length 3.

------------------------------------------------------------

🔥 Pattern: Sliding Window (Longest substring with unique characters)

------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, maxLen = 0;

        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If character is already seen, move left pointer
            if (lastIndex.containsKey(c)) {
                left = Math.max(left, lastIndex.get(c) + 1);
            }

            lastIndex.put(c, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}