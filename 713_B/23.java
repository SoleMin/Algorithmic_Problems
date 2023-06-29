import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Wolfgang Beyer
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int found = 0;
        int queryCount = 0;
        int[] result = new int[8];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            //int n = 100;
            //int n = 65536;


            int left = 1;
            int right = n + 1;
            while (left + 1 < right) {
                int middle = (left + right) / 2;
                int res = query(middle, 1, n, n);
                if (res == 2) left = middle;
                else if (res == 1) {
                    //System.out.println("Searching single: ");
                    findSingle(middle, 1, n, n);
                    found++;
                    break;
                } else {
                    right = middle;
                }
            }

            int top = 1;
            int bottom = n + 1;
            while (top + 1 < bottom) {
                int middle = (top + bottom) / 2;
                int res = query(1, middle, n, n);
                if (res == 2) top = middle;
                else if (res == 1) {
                    if ((found == 0) || (!containsRect(1, middle, n, n, result[0], result[1], result[2], result[3]))) {
                        //System.out.println("Searching single: ");
                        findSingle(1, middle, n, n);
                        found++;
                    }
                    break;
                } else {
                    bottom = middle;
                }
            }

            if (found < 2) {
                //System.out.println("Dia 3: ");
                left = 0;
                right = n;
                while (left + 1 < right) {
                    int middle = (left + right) / 2;
                    int res = query(1, 1, middle, n);
                    if (res == 2) right = middle;
                    else if (res == 1) {
                        if ((found == 0) || (!containsRect(1, 1, middle, n, result[0], result[1], result[2], result[3]))) {
                            //System.out.println("Searching single: ");
                            findSingle(1, 1, middle, n);
                            found++;
                        }
                        break;
                    } else {
                        left = middle;
                    }
                }
            }

            if (found < 2) {
                //System.out.println("Dia 4:");
                top = 0;
                bottom = n;
                while (top + 1 < bottom) {
                    int middle = (top + bottom) / 2;
                    int res = query(1, 1, n, middle);
                    if (res == 2) bottom = middle;
                    else if (res == 1) {
                        if ((found == 0) || (!containsRect(1, 1, n, middle, result[0], result[1], result[2], result[3]))) {
                            //System.out.println("Searching single: ");
                            findSingle(1, 1, n, middle);
                            found++;
                        }
                        break;
                    } else {
                        top = middle;
                    }
                }
            }

            System.out.print("! ");
            for (int i = 0; i < 8; i++) System.out.print(result[i] + " ");
            //System.out.println("\n" + queryCount + " queries used");
        }

        public boolean containsRect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
            if ((x1 <= x3) && (y1 <= y3) && (x2 >= x4) && (y2 >= y4)) return true;
            return false;
        }

        public void findSingle(int x1, int y1, int x2, int y2) {
            x1 = findTopX(x1, y1, x2, y2);
            y1 = findTopY(x1, y1, x2, y2);
            x2 = findBottomX(x1, y1, x2, y2);
            y2 = findBottomY(x1, y1, x2, y2);
            //System.out.println("x1: " + x1 + ", y1: " + y1 + ", x2: " + x2 + ", y2: " + y2);
            result[0 + 4 * found] = x1;
            result[1 + 4 * found] = y1;
            result[2 + 4 * found] = x2;
            result[3 + 4 * found] = y2;
        }

        public int findTopX(int x1, int y1, int x2, int y2) {
            int left = x1;
            int right = x2;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (query(mid, y1, x2, y2) == 1) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            while (query(right, y1, x2, y2) == 0) right--;
            return right;
        }

        public int findTopY(int x1, int y1, int x2, int y2) {
            int left = y1;
            int right = y2;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (query(x1, mid, x2, y2) == 1) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            while (query(x1, right, x2, y2) == 0) right--;
            return right;
        }

        public int findBottomX(int x1, int y1, int x2, int y2) {
            int left = x1;
            int right = x2;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (query(x1, y1, mid, y2) == 1) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            while (query(x1, y1, left, y2) == 0) left++;
            return left;
        }

        public int findBottomY(int x1, int y1, int x2, int y2) {
            int left = y1;
            int right = y2;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (query(x1, y1, x2, mid) == 1) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            while (query(x1, y1, x2, left) == 0) left++;
            return left;
        }

        public int query(int x1, int y1, int x2, int y2) {
            queryCount++;

            System.out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
            System.out.flush();
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();


        /*int ret = 0;
        //if(x1 <= 17 && 57 <= x2 && y1 <= 80 && 80 <= y2) ++ret;
	    //if(x1 <= 25 && 88 <= x2 && y1 <= 51 && 61 <= y2) ++ret;
        if(x1 <= 10 && 10 <= x2 && y1 <= 11 && 11 <= y2) ++ret;
        //if(x1 <= 11 && 11 <= x2 && y1 <= 10 && 10 <= y2) ++ret;
        if(x1 <= 10 && 10 <= x2 && y1 <= 15 && 15 <= y2) ++ret;
        //System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 + ": " + ret);
	    return ret;*/
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}

