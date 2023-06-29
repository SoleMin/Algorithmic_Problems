import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Washoum
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1PlaylistForPolycarpEasyVersion solver = new G1PlaylistForPolycarpEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1PlaylistForPolycarpEasyVersion {
        static final int mod = (int) 1e9 + 7;

        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            int t = sc.nextInt();
            G1PlaylistForPolycarpEasyVersion.Song[] songs = new G1PlaylistForPolycarpEasyVersion.Song[n];
            for (int i = 0; i < n; i++) {
                songs[i] = new G1PlaylistForPolycarpEasyVersion.Song(sc.nextInt(), sc.nextInt());
            }
            long ans = 0;
            for (int mask = 1; mask < (1 << n); mask++) {
                int nb = 0;
                int tot = 0;
                int type1 = 0;
                int type2 = 0;
                int type3 = 0;
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & mask) > 0) {
                        nb++;
                        tot += songs[j].l;
                        if (songs[j].type == 1) {
                            type1++;
                        } else if (songs[j].type == 2) {
                            type2++;
                        } else {
                            type3++;
                        }
                    }
                }

                if (tot == t) {
                    long[][][][][] dp = new long[nb + 1][3][type1 + 1][type2 + 1][type3 + 1];
                    boolean[][][][][] go = new boolean[nb + 1][3][type1 + 1][type2 + 1][type3 + 1];
                    if (type1 > 0) {
                        go[1][0][type1 - 1][type2][type3] = true;
                        dp[1][0][type1 - 1][type2][type3] = type1;
                    }
                    if (type2 > 0) {
                        go[1][1][type1][type2 - 1][type3] = true;
                        dp[1][1][type1][type2 - 1][type3] = type2;
                    }
                    if (type3 > 0) {
                        go[1][2][type1][type2][type3 - 1] = true;
                        dp[1][2][type1][type2][type3 - 1] = type3;
                    }
                    for (int i = 0; i < nb; i++) {
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j <= type1; j++) {
                                for (int k = 0; k <= type2; k++) {
                                    for (int l = 0; l <= type3; l++) {
                                        if (go[i][m][j][k][l]) {
                                            if (m == 0) {
                                                if (k > 0) {
                                                    dp[i + 1][1][j][k - 1][l] += dp[i][m][j][k][l] * k;
                                                    dp[i + 1][1][j][k - 1][l] %= mod;
                                                    go[i + 1][1][j][k - 1][l] = true;
                                                }
                                                if (l > 0) {
                                                    dp[i + 1][2][j][k][l - 1] += dp[i][m][j][k][l] * l;
                                                    dp[i + 1][2][j][k][l - 1] %= mod;
                                                    go[i + 1][2][j][k][l - 1] = true;
                                                }
                                            } else if (m == 1) {
                                                if (j > 0) {
                                                    dp[i + 1][0][j - 1][k][l] += dp[i][m][j][k][l] * j;
                                                    dp[i + 1][0][j - 1][k][l] %= mod;
                                                    go[i + 1][0][j - 1][k][l] = true;
                                                }
                                                if (l > 0) {
                                                    dp[i + 1][2][j][k][l - 1] += dp[i][m][j][k][l] * l;
                                                    dp[i + 1][2][j][k][l - 1] %= mod;
                                                    go[i + 1][2][j][k][l - 1] = true;
                                                }
                                            } else {
                                                if (j > 0) {
                                                    dp[i + 1][0][j - 1][k][l] += dp[i][m][j][k][l] * j;
                                                    dp[i + 1][0][j - 1][k][l] %= mod;
                                                    go[i + 1][0][j - 1][k][l] = true;
                                                }
                                                if (k > 0) {
                                                    dp[i + 1][1][j][k - 1][l] += dp[i][m][j][k][l] * k;
                                                    dp[i + 1][1][j][k - 1][l] %= mod;
                                                    go[i + 1][1][j][k - 1][l] = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    long toadd = 0;
                    for (int i = 0; i < 3; i++) {
                        toadd += dp[nb][i][0][0][0];
                    }
                    ans += toadd;
                    ans %= (int) 1e9 + 7;
                }
            }
            out.println(ans);
        }

        static class Song {
            int l;
            int type;

            public Song(int x, int y) {
                l = x;
                type = y;
            }

        }

    }

    static class inputClass {
        BufferedReader br;
        StringTokenizer st;

        public inputClass(InputStream in) {

            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

