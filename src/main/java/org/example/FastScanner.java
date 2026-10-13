package org.example;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class FastScanner {
    private final InputStream input;
    private final byte[] buffer = new byte[1 << 16];

    private int position = 0;
    private int length = 0;

    public FastScanner(InputStream input) {
        this.input = input;
    }

    private int read() throws IOException {
        if (position >= length) {
            length = input.read(buffer);
            position = 0;

            if (length == -1) {
                return -1;
            }
        }

        return buffer[position++] & 0xFF;
    }

    public long nextLong() throws IOException {
        int c;

        do {
            c = read();

            if (c == -1) {
                throw new EOFException("Недостаточно входных данных");
            }
        } while (c <= ' ');

        boolean negative = false;

        if (c == '-') {
            negative = true;
            c = read();
        }

        long value = 0;

        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = read();
        }

        return negative ? -value : value;
    }

    public int nextInt() throws IOException {
        return (int) nextLong();
    }
}