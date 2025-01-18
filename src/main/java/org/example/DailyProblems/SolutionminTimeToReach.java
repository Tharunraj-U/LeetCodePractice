package org.example.DailyProblems;

import java.util.*;

class SolutionminTimeToReach {
    public int minTimeToReach(int[][] moveTime) {
        // Directions: right, left, down, up
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = moveTime.length, cols = moveTime[0].length;

        // Priority queue for Dijkstra's algorithm: {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // Start at (0, 0) with time 0

        // Visited array to avoid revisiting cells with the same or higher cost
        int[][] visited = new int[rows][cols];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], row = current[1], col = current[2];

            // If we've reached the bottom-right corner, return the time
            if (row == rows - 1 && col == cols - 1) {
                return time;
            }

            // Explore all 4 possible directions
            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                // Check if the new position is within bounds
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                    // The earliest time you can reach the new cell
                    int waitTime = Math.max(time + 1, moveTime[newRow][newCol]);

                    // Only process this cell if we can reach it faster than previously recorded
                    if (waitTime < visited[newRow][newCol]) {
                        visited[newRow][newCol] = waitTime;
                        pq.offer(new int[]{waitTime, newRow, newCol});
                    }
                }
            }
        }

        // If no valid path exists, return -1 (shouldn't happen for valid input)
        return -1;
    }

    public static void main(String[] args) {
        int arr[][]={{0,4},{4,4}};
        System.out.println(new SolutionminTimeToReach().minTimeToReach(arr));
    }
}
