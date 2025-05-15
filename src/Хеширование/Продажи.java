package Хеширование;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> customers = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            if (parts.length != 3) continue;

            String customer = parts[0];
            String product = parts[1];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                continue;
            }

            customers
                    .computeIfAbsent(customer, k -> new HashMap<>())
                    .merge(product, quantity, Integer::sum);
        }
        scanner.close();

        List<String> sortedCustomers = new ArrayList<>(customers.keySet());
        Collections.sort(sortedCustomers);

        for (String customer : sortedCustomers) {
            Map<String, Integer> products = customers.get(customer);

            List<String> sortedProducts = new ArrayList<>(products.keySet());
            Collections.sort(sortedProducts);

            System.out.println(customer + ":");
            for (String product : sortedProducts) {
                System.out.println(product + " " + products.get(product));
            }
        }
    }
}