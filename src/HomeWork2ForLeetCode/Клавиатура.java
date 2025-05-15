package HomeWork2ForLeetCode;

import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] capacitiesStr = scanner.nextLine().split(" ");
        int[] capacities = new int[n];
        for (int i = 0; i < n; i++) {
            capacities[i] = Integer.parseInt(capacitiesStr[i]);
        }

        int k = scanner.nextInt();
        scanner.nextLine();
        String[] pressesStr = scanner.nextLine().split(" ");
        int[] presses = new int[k];
        for (int i = 0; i < k; i++) {
            presses[i] = Integer.parseInt(pressesStr[i]);
        }

        for (int i = 0; i < n; i++) {
            int keyIndex = i + 1;
            int currentCapacity = capacities[i];

            int pressCount = 0;
            for (int press : presses) {
                if (press == keyIndex) {
                    pressCount++;
                }
            }

            if (pressCount > currentCapacity) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
