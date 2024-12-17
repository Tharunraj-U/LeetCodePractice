package org.example.DailyProblems;

import java.util.Arrays;

class  AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);
        
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;
        
        // Step 2: Binary search on the distance
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if we can place all cows with at least 'mid' distance
            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update the result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }
        
        return result;
    }
    
    // Helper method to check if cows can be placed with at least 'distance' apart
    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place another cow
                lastPosition = stalls[i];
            }
            if (count == k) return true; // Successfully placed all cows
        }
        
        return false; // Not possible to place all cows
    }
}
