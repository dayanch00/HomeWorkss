package HomeWork5;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(reader.readLine());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] nodes = reader.readLine().split(" ");
        int start = Integer.parseInt(nodes[0]) - 1;
        int end = Integer.parseInt(nodes[1]) - 1;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int shortestPathLength = bfs(graph, start, end, parent);

        if (shortestPathLength == -1) {
            writer.write("-1\n");
        } else {
            writer.write(shortestPathLength + "\n");


            List<Integer> path = new ArrayList<>();
            for (int v = end; v != -1; v = parent[v]) {
                path.add(v + 1);
            }
            Collections.reverse(path);
            for (int v : path) {
                writer.write(v + " ");
            }
            writer.write("\n");
        }

        reader.close();
        writer.close();
    }

    private static int bfs(int[][] graph, int start, int end, int[] parent) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) return distance[node];

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[node] + 1;
                    parent[neighbor] = node;
                }
            }
        }
        return -1;
    }
}

