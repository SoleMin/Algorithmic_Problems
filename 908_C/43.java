
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt(), R = sc.nextInt();
        double answer[] = new double[N];
        int[] x = new int[N];

        for (int i = 0; i < N; i++)
            x[i] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            answer[i] = R;
            for (int j = 0; j < i; j++) {
                int dist = Math.abs(x[i] - x[j]);
                if(dist <= 2 * R) {
                    double t = answer[j] + Math.sqrt(4 * R * R - dist * dist);
                    answer[i] = Math.max(answer[i], t);
                }
            }
        }
        for(int i = 0; i < N; ++i)
            out.print(answer[i] + " ");

        out.println();

        out.flush();
        out.close();
    }


    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

    }
    }
