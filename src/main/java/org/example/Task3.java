package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Task3 {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(
                intervals,
                Comparator.comparingInt((int[] interval) -> interval[0])
        );

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < n; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                result.append(currentStart)
                        .append(' ')
                        .append(currentEnd)
                        .append('\n');

                count++;

                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        result.append(currentStart)
                .append(' ')
                .append(currentEnd)
                .append('\n');

        count++;

        System.out.println(count);
        System.out.print(result);
    }
}