package HomeWork2ForLeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Product {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numsStr = line.split(" ");
        int[] nums = new int[numsStr.length];

        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        Arrays.sort(nums);
        long product1 = (long)nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        long product2 = (long)nums[0] * nums[1] * nums[nums.length - 1];

        if (product1 > product2) {
            System.out.println(nums[nums.length - 1] + " " + nums[nums.length - 2] + " " + nums[nums.length - 3]);
        } else {

            if (nums[0] > nums[1]) {
                System.out.println(nums[0] + " " + nums[1] + " " + nums[nums.length - 1]);
            } else {
                System.out.println(nums[1] + " " + nums[0] + " " + nums[nums.length - 1]);
            }
        }
    }
}

