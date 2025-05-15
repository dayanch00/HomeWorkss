package HomeWork3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("+")) {
                int goblinId = Integer.parseInt(parts[1]);
                queue.addLast(goblinId);
            } else if (parts[0].equals("*")) {
                int goblinId = Integer.parseInt(parts[1]);
                int middle = queue.size() / 2;

                Deque<Integer> tempQueue = new LinkedList<>();
                for (int j = 0; j < middle; j++) {
                    tempQueue.addLast(queue.removeFirst());
                }
                tempQueue.addLast(goblinId);

                while (!queue.isEmpty()) {
                    tempQueue.addLast(queue.removeFirst());
                }
                queue = tempQueue;
            } else {
                int leavingGoblin = queue.removeFirst();
                writer.write(String.valueOf(leavingGoblin));
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}