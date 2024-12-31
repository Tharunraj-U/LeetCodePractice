package org.example.DailyProblems;

import java.util.Arrays;

class LongestConsecutiveSolution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length ==0)return 0;
        Arrays.sort(nums);
        int streak=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] !=nums[i]){
                if(nums[i]-1 == nums[i-1]){
                    streak++;
                }else{
                    max=Math.max(streak,max);
                    streak=1;
                }
            }
        }
        return Math.max(streak,max);
    }
}