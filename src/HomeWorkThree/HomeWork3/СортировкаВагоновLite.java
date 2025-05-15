package HomeWork3;

import java.util.Scanner;
import java.util.Stack;

public class TrainArrangement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] cars = new int[n];

        for (int i = 0; i < n; i++) {
            cars[i] = scanner.nextInt();
        }

        scanner.close();

        if (canArrange(cars)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean canArrange(int[] cars) {
        Stack<Integer> siding = new Stack<>();
        int expected = 1;
        int i = 0;

        while (i < cars.length) {
            if (cars[i] == expected) {
                expected++;
                i++;

                while (!siding.isEmpty() && siding.peek() == expected) {
                    siding.pop();
                    expected++;
                }
            } else if (!siding.isEmpty() && siding.peek() < cars[i]) {
                return false;
            } else {
                siding.push(cars[i]);
                i++;
            }
        }

        while (!siding.isEmpty()) {
            if (siding.peek() == expected) {
                siding.pop();
                expected++;
            } else {
                return false;
            }
        }

        return true;
    }
}
