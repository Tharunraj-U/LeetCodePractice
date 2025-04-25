package org.example.ZohoLevel_2;

import java.util.*;

public class SnakeLadder {

    static class Node {
        int pos, moves;
        Node(int pos, int moves) {
            this.pos = pos;
            this.moves = moves;
        }
    }

    public static int minThrow(int N, int[] arr) {
        // Create snake/ladder jump map
        Map<Integer, Integer> jumps = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i += 2) {
            jumps.put(arr[i], arr[i + 1]);
        }

        boolean[] visited = new boolean[31]; // 1 to 30
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.pos == 30) return curr.moves;

            for (int dice = 1; dice <= 6; dice++) {
                int next = curr.pos + dice;
                if (next > 30) continue;

                // Apply jump if there's a snake or ladder
                if (jumps.containsKey(next)) {
                    next = jumps.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, curr.moves + 1));
                }
            }
        }

        return -1; // unreachable
    }

    public static void main(String[] args) {
        int[] arr = {
            3, 22, 5, 8, 11, 26, 20, 29,
            27, 1, 21, 9, 17, 4, 19, 7
        };
        System.out.println("Min throws: " + minThrow(arr.length / 2, arr));
    }
}
