package org.example.DailyProblems;

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;

        // Initialize the map with sum 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if (sum - k) exists in the map
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            // Only add the sum to the map if it is not already present
            // to ensure the longest subarray is found
            map.putIfAbsent(sum, i);
        }

        return max;
    }
}