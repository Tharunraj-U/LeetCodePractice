package org.example.DailyProblems;

import java.util.*;

class MinimumDiameterAfterMergeSolution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = getTreeDiameter(edges1);
        int diameter2 = getTreeDiameter(edges2);
        int radius1 = (diameter1 + 1) / 2;
        int radius2 = (diameter2 + 1) / 2;
        return Math.max(diameter1, Math.max(diameter2, radius1 + radius2 + 1));
    }
    
    private int getTreeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int farthestNode = bfs(0, graph)[0];
        int diameter = bfs(farthestNode, graph)[1];
        return diameter;
    }
    
    private int[] bfs(int start, List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        int farthestNode = start, maxDistance = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], distance = current[1];
            farthestNode = node;
            maxDistance = distance;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        return new int[]{farthestNode, maxDistance};
    }
}
