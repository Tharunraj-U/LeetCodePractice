package org.example.DailyProblems;

class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int i=0,totalSum=0,j=cardPoints.length-1, ans=0;
        while(k>0){
            totalSum+=cardPoints[i++];
            k--;
        }
        i--;
        while(i >-1){
               ans=Math.max(totalSum,ans);
               totalSum-=cardPoints[i--];
               totalSum+=cardPoints[j--];
        }
        ans=Math.max(totalSum,ans);
        return ans;
        
    }
}