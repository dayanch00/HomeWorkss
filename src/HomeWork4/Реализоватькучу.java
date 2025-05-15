package HomeWork4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> heap = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            int command = Integer.parseInt(line[0]);

            if (command == 0) {
                int number = Integer.parseInt(line[1]);
                heap.add(number);
            } else {
                if (!heap.isEmpty()) {
                    Integer maxElement = Collections.max(heap);
                    writer.write(String.valueOf(maxElement));
                    writer.newLine();
                    heap.remove(maxElement);
                }

            }
        }

        reader.close();
        writer.close();
    }
}

