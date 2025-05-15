package HomeWork5;


import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> connectedComponents = findConnectedComponents(adj, n);

        System.out.println(connectedComponents.size());

        for (List<Integer> component : connectedComponents) {
            System.out.println(component.size());
            for (int i = 0; i < component.size(); i++) {
                System.out.print(component.get(i) + (i == component.size() - 1 ? "" : " "));
            }
            System.out.println();
        }

        scanner.close();
    }

    public static List<List<Integer>> findConnectedComponents(List<List<Integer>> adj, int n) {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(adj, i, visited, component);
                Collections.sort(component);
                connectedComponents.add(component);
            }
        }

        return connectedComponents;
    }

    public static void dfs(List<List<Integer>> adj, int u, boolean[] visited, List<Integer> component) {
        visited[u] = true;
        component.add(u);

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, v, visited, component);
            }
        }
    }
}
