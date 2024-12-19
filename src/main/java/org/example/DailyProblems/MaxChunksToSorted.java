package org.example.DailyProblems;

class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int ans=0,max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
            if(max==i)ans++;
        }
        return ans;
    }
}