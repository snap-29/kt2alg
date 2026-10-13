package org.example;

public class Task2 {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            prefix[i + 1] = prefix[i] + value;
        }

        int q = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            long sum = prefix[right + 1] - prefix[left];

            result.append(sum).append('\n');
        }

        System.out.print(result);
    }
}