package org.example.DailyProblems;

class SolutionlongestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1,c=1;
        for(int i=0;i<nums.length-1;i++){
           if(nums[i] < nums[i+1]){
              c++;
              ans=Math.max(c,ans);
           }else{
            c=1;
           }
        }
        c=1;
        for(int i=0;i<nums.length-1;i++){
           if(nums[i] > nums[i+1]){
              c++;
              ans=Math.max(c,ans);
           }else{
            c=1;
           }
        }
        return ans ;
    }
}