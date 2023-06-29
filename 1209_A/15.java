import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static PrintWriter writer;

    static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static void banana() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int c = 0;
        while(true) {
            int mn = 1000;
            for (int i = 0; i < n; i++) {
                if(color[i] == 0) {
                    mn = Math.min(mn, a[i]);
                }
            }
            if (mn == 1000) {
                break;
            }
            c++;
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    if (a[i] % mn == 0) {
                        color[i] = c;
                    }
                }
            }
        }
        writer.println(c);
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = null;
        writer = new PrintWriter(System.out);
        banana();
        reader.close();
        writer.close();
    }
}
