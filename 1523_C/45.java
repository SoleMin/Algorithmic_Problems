/*
⠀⠀⠀⠀⣠⣶⡾⠏⠉⠙⠳⢦⡀⠀⠀⠀⢠⠞⠉⠙⠲⡀⠀
⠀⠀⠀⣴⠿⠏⠀⠀⠀⠀⠀⠀⢳⡀⠀⡏⠀⠀Y⠀⠀⢷
⠀⠀⢠⣟⣋⡀⢀⣀⣀⡀⠀⣀⡀⣧⠀⢸⠀⠀A⠀⠀ ⡇
⠀⠀⢸⣯⡭⠁⠸⣛⣟⠆⡴⣻⡲⣿⠀⣸⠀⠀S⠀  ⡇
⠀⠀⣟⣿⡭⠀⠀⠀⠀⠀⢱⠀⠀⣿⠀⢹⠀⠀H⠀⠀ ⡇
⠀⠀⠙⢿⣯⠄⠀⠀⠀⢀⡀⠀⠀⡿⠀⠀⡇⠀⠀⠀⠀⡼
⠀⠀⠀⠀⠹⣶⠆⠀⠀⠀⠀⠀⡴⠃⠀⠀⠘⠤⣄⣠⠞⠀
⠀⠀⠀⠀⠀⢸⣷⡦⢤⡤⢤⣞⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢀⣤⣴⣿⣏⠁⠀⠀⠸⣏⢯⣷⣖⣦⡀⠀⠀⠀⠀⠀⠀
⢀⣾⣽⣿⣿⣿⣿⠛⢲⣶⣾⢉⡷⣿⣿⠵⣿⠀⠀⠀⠀⠀⠀
⣼⣿⠍⠉⣿⡭⠉⠙⢺⣇⣼⡏⠀⠀⠀⣄⢸⠀⠀⠀⠀⠀⠀
⣿⣿⣧⣀⣿………⣀⣰⣏⣘⣆⣀⠀⠀
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; // System.out is a PrintStream
// import java.util.Arrays;
import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.Collections;    //  for sorting ArrayList mainly
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Random;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        FastScanner scn = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        for (int tc = scn.nextInt(); tc > 0; tc--) {
            int N = scn.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scn.nextInt();
            }
            StringBuilder[] ans = new StringBuilder[N];
            ans[0] = new StringBuilder("1");
            ArrayDeque<Integer> st = new ArrayDeque<>();
            st.addLast(0);
            for (int i = 1; i < N; i++) {
                // System.out.println(st);
                ans[i] = new StringBuilder();
                if (arr[i] == 1) {
                    st.addLast(i);
                    ans[i].append(ans[i - 1].toString() + ".1");
                } else {
                    while (arr[st.getLast()] != arr[i] - 1) {
                        st.removeLast();
                    }
                    int pos = st.removeLast();
                    String[] prev = ans[pos].toString().split("[.]");
                    for (int j = 0, sz = prev.length - 1; j < sz; j++) {
                        ans[i].append(prev[j] + ".");
                    }
                    ans[i].append(arr[i] + "");
                    st.addLast(i);
                }
            }
            for (StringBuilder str : ans) {
                out.println(str);
            }
        }
        out.close();
    }

    private static int gcd(int num1, int num2) {
        int temp = 0;
        while (num2 != 0) {
            temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    private static int lcm(int num1, int num2) {
        return (int)((1L * num1 * num2) / gcd(num1, num2));
    }

    private static void ruffleSort(int[] arr) {
        // int N = arr.length;
        // Random rand = new Random();
        // for (int i = 0; i < N; i++) {
        //     int oi = rand.nextInt(N), temp = arr[i];
        //     arr[i] = arr[oi];
        //     arr[oi] = temp;
        // }
        // Arrays.sort(arr);
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            if (st.hasMoreTokens()) {
                return st.nextToken("").trim();
            }
            try {
                return br.readLine().trim();
            } catch (IOException err) {
                err.printStackTrace();
            }
            return "";
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
