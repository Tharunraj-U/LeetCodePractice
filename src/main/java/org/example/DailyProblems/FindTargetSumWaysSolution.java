package org.example.DailyProblems;

class FindTargetSumWaysSolution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Ensure target + sum is non-negative and even
        if (target > sum || target + sum < 0 || (target + sum) % 2 != 0) {
            return 0;
        }
        
        int subsetSum = (target + sum) / 2;
        return countSubsets(nums, subsetSum);
    }
    
    private int countSubsets(int[] nums, int subsetSum) {
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There's one way to achieve sum 0
        
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}
