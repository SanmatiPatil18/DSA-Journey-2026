/* 
904. Fruit Into Baskets

# Problem Statement:
You are given an integer array fruits where fruits[i] represents the type of fruit produced by the ith tree.

You have two baskets, and each basket can hold only one type of fruit, but unlimited quantity.

Rules:
- Start from any tree
- Pick exactly one fruit from each tree while moving to the right
- Fruits must fit into one of the two baskets
- If a fruit type doesn't fit, you must stop

Return the maximum number of fruits you can collect.

------------------------------------------------------------

# Intuition:
We need to find the longest subarray that contains at most 2 distinct fruit types.

- Each basket can hold only one type → total allowed types = 2
- So we maintain a window with at most 2 distinct elements

------------------------------------------------------------

# Approach (Sliding Window):
- Use two pointers (left and right)
- Use a HashMap to store frequency of fruits
- Expand window by moving right
- If distinct types > 2 → shrink window from left
- Track maximum window size

------------------------------------------------------------

# Complexity:
Time Complexity: O(n)
Space Complexity: O(1) (map size at most 3)

------------------------------------------------------------

# Example:
Input: fruits = [1,2,1]
Output: 3

Explanation:
We can pick all fruits since only 2 types exist.

------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
