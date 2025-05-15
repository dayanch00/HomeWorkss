package HomeWork5;

import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == destination) {
                return true;
            }

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return false;
    }
}

