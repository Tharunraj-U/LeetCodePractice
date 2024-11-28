//package org.example;
//
//import java.util.*;
//
//public class SlidingPuzzle {
//    class Solution {
//        public int slidingPuzzle(int[][] board) {
//            // Convert the board into a string representation
//            StringBuilder str = new StringBuilder();
//            for (int[] row : board) {
//                for (int val : row) {
//                    str.append(val);
//                }
//            }
//
//            // Goal state for the 2x3 board
//            String target = "123450";
//
//            // BFS setup
//            Queue<String> queue = new LinkedList<>();
//            queue.add(str.toString());
//            Set<String> visited = new HashSet<>();
//            visited.add(str.toString());
//
//            // Neighbor positions for each index in the 1D representation
//            List<List<Integer>> neighbors = List.of(
//                    List.of(1, 3),          // 0 -> Can move to 1, 3
//                    List.of(0, 2, 4),       // 1 -> Can move to 0, 2, 4
//                    List.of(1, 5),          // 2 -> Can move to 1, 5
//                    List.of(0, 4),          // 3 -> Can move to 0, 4
//                    List.of(1, 3, 5),       // 4 -> Can move to 1, 3, 5
//                    List.of(2, 4)           // 5 -> Can move to 2, 4
//            );
//
//            int level = 0; // Steps counter
//
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    String current = queue.poll();
//                    if (current.equals(target)) {
//                        return level;
//                    }
//
//                    // Find the position of '0' (empty space)
//                    int zeroIndex = current.indexOf('0');
//
//                    // Try all possible swaps
//                    for (int neighbor : neighbors.get(zeroIndex)) {
//                        String next = swap(current, zeroIndex, neighbor);
//                        if (!visited.contains(next)) {
//                            visited.add(next);
//                            queue.add(next);
//                        }
//                    }
//                }
//                level++; // Increment step count
//            }
//
//            return -1; // If no solution is found
//        }
//
//        // Helper function to swap characters in a string
//        private String swap(String s, int i, int j) {
//            char[] chars = s.toCharArray();
//            char temp = chars[i];
//            chars[i] = chars[j];
//            chars[j] = temp;
//            return new String(chars);
//        }
//    }
//
//}
