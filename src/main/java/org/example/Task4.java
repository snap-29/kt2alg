package org.example;

public class Task4 {

    public static boolean canShip(
            int[] weights,
            int days,
            long capacity
    ) {
        int usedDays = 1;
        long currentWeight = 0;

        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }

            if (currentWeight + weight > capacity) {
                usedDays++;
                currentWeight = 0;

                if (usedDays > days) {
                    return false;
                }
            }

            currentWeight += weight;
        }

        return true;
    }

    public static long minimumCapacity(int[] weights, int days) {
        long left = 0;
        long right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            long middle = left + (right - left) / 2;

            if (canShip(weights, days, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        int days = scanner.nextInt();

        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println(minimumCapacity(weights, days));
    }
}