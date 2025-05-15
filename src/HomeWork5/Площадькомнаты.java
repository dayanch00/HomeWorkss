package HomeWork5;


import java.util.Scanner;

public class RoomArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }

        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;

        System.out.println(calculateRoomArea(maze, startRow, startCol));
        scanner.close();
    }

    public static int calculateRoomArea(char[][] maze, int startRow, int startCol) {
        if (startRow < 0 || startRow >= maze.length || startCol < 0 || startCol >= maze[0].length || maze[startRow][startCol] != '.') {
            return 0;
        }

        int area = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        area = dfs(maze, startRow, startCol, visited);

        return area;
    }

    private static int dfs(char[][] maze, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] != '.' || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int area = 1;

        area += dfs(maze, row + 1, col, visited);
        area += dfs(maze, row - 1, col, visited);
        area += dfs(maze, row, col + 1, visited);
        area += dfs(maze, row, col - 1, visited);

        return area;
    }
}
