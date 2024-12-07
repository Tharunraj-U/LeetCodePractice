package org.example.DailyProblems;

import java.util.Arrays;

public class MaxBag {
    public int minimumSize(int[] nums, int max) {
        for(int i = 1; i<= Arrays.stream(nums).max().getAsInt(); i++){
            int totalDiv=0;
            for(int val:nums){
                int noDiv = (int) Math.ceil((double) val / i);
                System.out.print(" "+i+" "+noDiv+"        ");
                totalDiv+=noDiv-1;
            }
            System.out.println();
            if(totalDiv <= max){
                return i;
            }
        }
        return 0;
    }
}
