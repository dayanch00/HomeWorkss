package HomeWork5;

import java.util.*;
import java.io.*;

public class Main {
    private static int[][] graph;
    private static boolean[] visited;
    private static int[] parent;
    private static List<Integer> cycle;
    private static int cycleStart = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        graph = new int[n][n];
        visited = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(parts[j]);
            }
        }

        cycle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, -1)) {
                break;
            }
        }

        if (cycle.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YEES");
            System.out.println(cycle.size());
            for (int node : cycle) {
                System.out.print((node + 1) + " ");
            }
        }
    }

    private static boolean dfs(int node, int parentNode) {
        visited[node] = true;
        parent[node] = parentNode;

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[node][neighbor] == 1) {
                if (neighbor == parentNode) continue;

                if (visited[neighbor]) {
                    cycleStart = neighbor;
                    collectCycle(node);
                    return cycle.size() >= 3;
                } else {
                    if (dfs(neighbor, node)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void collectCycle(int node) {
        cycle.add(node);
        int current = parent[node];
        while (current != cycleStart) {
            cycle.add(current);
            current = parent[current];
        }
        cycle.add(cycleStart);

        if (cycle.size() < 3) {
            cycle.clear();
            cycleStart = -1;
        }
    }
}
