package org.example.DailyProblems;

class MaxScoreSightseeingPairSolution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=values[0],ans=max,dummy=max;
        for(int i=1;i<values.length;i++){
            max=values[i]+dummy-1;
            dummy=Math.max(values[i],dummy-1);
            ans=Math.max(ans,max);
        }
        return ans;
    }
}