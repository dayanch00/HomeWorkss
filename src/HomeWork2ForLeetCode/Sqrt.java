package HomeWork2ForLeetCode;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }


        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;
    }
}
