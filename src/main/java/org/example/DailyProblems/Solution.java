package org.example.DailyProblems;

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] cop = new int[n][2];

        // Copy values and their indices
        for (int i = 0; i < n; i++) {
            cop[i][0] = nums[i];
            cop[i][1] = i;
        }

        // Sort by values
        Arrays.sort(cop, (a, b) -> a[0] - b[0]);

        // Boolean array to mark visited elements
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                List<Integer> indices = new ArrayList<>();
                int start = i;

                // Collect all indices within the limit
                while (start < n && cop[start][0] - cop[i][0] <= limit) {
                    indices.add(cop[start][1]);
                    used[start++] = true;
                }

                // Sort the collected indices lexicographically
                Collections.sort(indices);

                // Assign sorted values back to the original array
                for (int j = 0; j < indices.size(); j++) {
                    nums[indices.get(j)] = cop[i + j][0];
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case
        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;

        int[] result = solution.lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(result)); // Expected: [1, 3, 5, 8, 9]
    }
}
