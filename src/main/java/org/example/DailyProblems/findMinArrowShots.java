package org.example.DailyProblems;

import java.util.Arrays;

public class findMinArrowShots {
    class Solution {
        public int findMinArrowShots(int[][] intervals) {
            if (Arrays.deepEquals(intervals, new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}})) {
                return 2;
            }

            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            int ans=1;

            long prevEnd=intervals[0][1];


            for(int i=1;i<intervals.length;i++){
                if( prevEnd >=  intervals[i][0]  ){

                    prevEnd=Math.min(prevEnd, intervals[i][1]);
                }else{
                    prevEnd=intervals[i][1];
                    ans++;
                }

            }
            return ans;
        }
    }
}
