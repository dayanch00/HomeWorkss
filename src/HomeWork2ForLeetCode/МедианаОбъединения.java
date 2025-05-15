package HomeWork2ForLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MedianOfUnion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int L = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> sequences = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] sequenceStr = scanner.nextLine().split(" ");
            List<Integer> sequence = new ArrayList<>();
            for (String s : sequenceStr) {
                sequence.add(Integer.parseInt(s));
            }
            sequences.add(sequence);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                List<Integer> mergedList = new ArrayList<>();
                mergedList.addAll(sequences.get(i));
                mergedList.addAll(sequences.get(j));

                Collections.sort(mergedList);

                int medianIndex = L - 1;
                int median = mergedList.get(medianIndex);

                System.out.println(median);
            }
        }
    }
}
