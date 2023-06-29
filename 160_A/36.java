 import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

    public class Test {
            static BufferedReader reader;
            static StringTokenizer tokenizer;
            static PrintWriter writer;

            static int nextInt() throws IOException {
                    return Integer.parseInt(nextToken());
            }

            static long nextLong() throws IOException {
                    return Long.parseLong(nextToken());
            }

            static double nextDouble() throws IOException {
                    return Double.parseDouble(nextToken());
            }

            static String nextToken() throws IOException {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                            tokenizer = new StringTokenizer(reader.readLine());
                    }
                    return tokenizer.nextToken();
            }

            public static void main(String[] args) throws IOException {
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    tokenizer = null;
                    writer = new PrintWriter(System.out);
                    solve();
                    reader.close();
                    writer.close();
            }

            private static void solve() throws IOException {
                int n=nextInt();
                int[] a=new int[n];
                int first=0;
                for (int i=0;i<n;i++)
                {
                    a[i]=nextInt();
                    first+=a[i];
                }
                Arrays.sort(a);
                int ans=1;
                int last=a[n-1];
                first-=a[n-ans];
                while (true)
                {
                    if (first<last)
                        break;
                    ans++;
                    last+=a[n-ans];
                    first-=a[n-ans];
                }
                writer.print(ans);
            }


    }