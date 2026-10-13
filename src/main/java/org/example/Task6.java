package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = scanner.nextInt();
            meetings[i][1] = scanner.nextInt();
        }

        Arrays.sort(
                meetings,
                Comparator.comparingInt((int[] meeting) -> meeting[0])
        );

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int maxRooms = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!endTimes.isEmpty() && endTimes.peek() <= start) {
                endTimes.poll();
            }

            endTimes.offer(end);
            maxRooms = Math.max(maxRooms, endTimes.size());
        }

        System.out.println(maxRooms);
    }
}