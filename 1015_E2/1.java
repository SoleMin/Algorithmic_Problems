//package codeforces;


import java.io.IOException;
import java.util.*;

/**
 * @author muhossain
 * @since 2021-01-02
 */

public class E2_1015 {

    public static void main(String[] args) {
        FasterScanner fs = new FasterScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        char[][] grid = new char[n][m];

        int starCount = 0;

        for (int i = 0; i < n; i++) {
            grid[i] = fs.nextLine().toCharArray();

            for (char ch : grid[i]) {
                if (ch == '*') {
                    starCount++;
                }
            }
        }

        int dimension = Math.max(n, m);

        int freq[][][] = new int[dimension][dimension][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '*') {
                    continue;
                }

                int upCount = 0;
                int leftCount = 0;

                if (i > 0 && grid[i - 1][j] == '*') {
                    upCount = freq[i - 1][j][0] + 1;
                }

                if (j > 0 && grid[i][j - 1] == '*') {
                    leftCount = freq[i][j - 1][1] + 1;
                }

                freq[i][j][0] = upCount;
                freq[i][j][1] = leftCount;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (grid[i][j] != '*') {
                    continue;
                }

                int rightCount = 0;
                int downCount = 0;

                if (grid[i][j + 1] == '*') {
                    rightCount = freq[i][j + 1][2] + 1;
                }

                if (grid[i + 1][j] == '*') {
                    downCount = freq[i + 1][j][3] + 1;
                }

                freq[i][j][2] = rightCount;
                freq[i][j][3] = downCount;
            }
        }

        int starLength[][][] = new int[dimension][dimension][1];

        List<Star> starList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                starLength[i][j][0] = Math.min(Math.min(freq[i][j][0], freq[i][j][1]),
                        Math.min(freq[i][j][2], freq[i][j][3]));

                starList.add(new Star(i, j, starLength[i][j][0]));
            }
        }

        starList.sort((s1, s2) -> (s2.length - s1.length));

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (Star s : starList) {

            int i = s.x;
            int j = s.y;
            int startLength = s.length;

            if (startLength == 0) {
                continue;
            }

            result.append(i + 1).append(" ").append(j + 1).append(" ").append(startLength).append("\n");

            count++;

            grid[i][j] = '#';

            int x = i;
            int y = j;
            int c = startLength;

            while (c > 0) {
                x--;
                c--;

//                if (grid[x][y] == '#') {
//                    break;
//                }

                grid[x][y] = '#';
            }

            x = i;
            y = j;
            c = startLength;

            while (c > 0) {
                y--;
                c--;

//                if (grid[x][y] == '#') {
//                    break;
//                }

                grid[x][y] = '#';
            }

            x = i;
            y = j;
            c = startLength;

            while (c > 0) {
                y++;
                c--;
//
//                if (grid[x][y] == '#') {
//                    break;
//                }

                grid[x][y] = '#';
            }

            x = i;
            y = j;
            c = startLength;

            while (c > 0) {
                x++;
                c--;

//                if (grid[x][y] == '#') {
//                    break;
//                }

                grid[x][y] = '#';
            }
        }

        boolean solvable = validateGrid(grid);

        System.out.println(solvable ? count + "\n" + result : -1);
    }

    private static boolean validateGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
//                    System.out.println("uncovered at => " + i + ": " + j);
                    return false;
                }
            }
        }

        return true;
    }

    private static class Star {
        int x;
        int y;
        int length;

        public Star(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    public static class FasterScanner {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}
