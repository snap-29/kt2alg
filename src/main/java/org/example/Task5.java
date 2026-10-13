package org.example;

import java.util.HashMap;
import java.util.Map;

public class Task5 {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();

        Map<Long, Long> frequency = new HashMap<>();

        frequency.put(0L, 1L);

        long prefix = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            prefix += value;

            count += frequency.getOrDefault(prefix - k, 0L);

            frequency.put(
                    prefix,
                    frequency.getOrDefault(prefix, 0L) + 1
            );
        }

        System.out.println(count);
    }
}