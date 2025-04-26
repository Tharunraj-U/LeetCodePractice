package org.example.DailyProblems;

class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
       long ans=0;
       int min=-1,max=-1,invalid=-1;
       for(int i=0;i<nums.length;i++){
        int val=nums[i];
          if(val == minK){
            min=i;
          }
          if(val == maxK){
            max=i;
          } if(val > maxK || val < minK){
            invalid=i;
          }
          int c=Math.max(Math.min(max,min)-invalid,0);
          ans+=c;
       }
       return ans; 
    }
}