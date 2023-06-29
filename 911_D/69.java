import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class D {

    int N,M;
    int[] a,l,r;

    private void solve() {
        N = nextInt();

        a = new int[N];
        for(int i = 0;i < N;i++) {
            a[i] = nextInt();
        }

        M = nextInt();

        l = new int[M];
        r = new int[M];
        for(int i = 0;i < M;i++) {
            l[i] = nextInt();
            r[i] = nextInt();
        }

        int count = 0;
        for(int i = 0;i < N - 1;i++) {
            for(int j = i + 1;j < N;j++) if (a[i] > a[j]) {
                count++;
            }
        }

        for(int i = 0;i < M;i++) {
            count += (r[i] - l[i] + 1) * (r[i] - l[i]) / 2;
            count %= 2;
            out.println(count == 0 ? "even" : "odd");
        }
    }

    public static void main(String[] args) {
        out.flush();
        new D().solve();
        out.close();
    }

    /* Input */
    private static final InputStream in = System.in;
    private static final PrintWriter out = new PrintWriter(System.out);
    private final byte[] buffer = new byte[2048];
    private int p = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (p < buflen)
            return true;
        p = 0;
        try {
            buflen = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buflen <= 0)
            return false;
        return true;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrint(buffer[p])) {
            p++;
        }
        return hasNextByte();
    }

    private boolean isPrint(int ch) {
        if (ch >= '!' && ch <= '~')
            return true;
        return false;
    }

    private int nextByte() {
        if (!hasNextByte())
            return -1;
        return buffer[p++];
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = -1;
        while (isPrint((b = nextByte()))) {
            sb.appendCodePoint(b);
        }
        return sb.toString();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}