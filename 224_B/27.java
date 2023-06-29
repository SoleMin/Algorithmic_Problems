import java.io.*;
import java.util.*;

public class CodeForces {
    static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    void runCase(int caseNum) throws IOException {
        int n = nextInt();
        int k = nextInt();
        int[] nums = new int[n];
        int distinct = 0;
        int L = -1, R = -1;
        int minLen = Integer.MAX_VALUE;
        int maxNum = 0;

        for (int i = 0; i < n; ++i) {
            nums[i] = nextInt();
            maxNum = Math.max(maxNum,  nums[i]);
        }
        int[] count = new int[maxNum + 1];
        int j = 0;

        for (int i = 0; i < n; ++i) {
            ++count[nums[i]];
            if (count[nums[i]] == 1) {
                ++distinct;
                if (distinct >= k) {
                    for (; j <= i; ++j) {
                        --count[nums[j]];
                        if (count[nums[j]] <= 0) {
                            --distinct;
                            if (distinct < k) {
                                if (i - j < minLen) {
                                    minLen = i - j;
                                    L = j + 1;
                                    R = i + 1;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        out.print(L + " " + R);
    }


    public static void main(String[] args) throws IOException {
        if (ONLINE_JUDGE){
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }else{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
        new CodeForces().runIt();
        out.flush();
        out.close();
        return;
    }

    static BufferedReader in;
    private StringTokenizer st;
    static PrintWriter out;

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line, " ");
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }


    void runIt() throws IOException {
        st = new StringTokenizer("");

//        int N = nextInt();
//        for (int i = 0; i < N; i++) {
//            runCase(i + 1);
//        }
        runCase(0);

        out.flush();
    }

}
