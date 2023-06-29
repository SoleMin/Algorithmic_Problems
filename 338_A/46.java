import java.io.*;
import java.util.StringTokenizer;

public class A {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void solve() throws IOException {
		final int mod = 1000*1000*1000+9;
		long n = readInt();
		long m = readInt();
		long k = readInt();
		long fail = n-m;
		long posl = n / k ;
		if(n % k != 0) {
			posl++;
		}
		if(posl <= fail) {
			out.println(m);
		} else {
			long d = fail - posl;
			long res = (k-1) * fail;
			m -= (k-1) * fail;
			long z = m / k;
			res += m % k;
			res %= mod;
			long x = binpow(2, z+1, mod);
			x -= 2;
			x += mod;
			x %= mod;
			x *= k;
			res += x;
			res %= mod;
			out.println(res);
		}
    }

	long binpow (long a, long n, long mod) {
		long res = 1;
		while (n != 0)
			if ((n & 1) != 0) {
				res *= a;
				res = res % mod;
				--n;
			}
			else {
				a *= a;
				a = a % mod;
				n >>= 1;
			}
		return res;
	}

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new A().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}