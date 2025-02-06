package org.example.DailyProblems;

class SolutionTupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        int n=nums.length,ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
               map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        for(int val:map.values()){
            if(val >1){
                ans+=(8*((val*(val-1))/2));
            }
        }
     return ans;   
    }
}