import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class E17 {

	static StreamTokenizer in;
	static PrintWriter out;
	
	static int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	static String nextString() throws IOException {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);
		
		int n = nextInt(), k = nextInt();
		int MAX = n, nprimes = 0;
		int[] primes = new int[MAX];
		boolean[] isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= MAX; i++) if (isPrime[i]) {
			primes[nprimes++] = i;
			for (int j = i + i; j <= MAX; j += i) isPrime[j] = false;
		}
		primes[nprimes] = Integer.MAX_VALUE;
		
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 1; i < nprimes; i++) {
			int x = primes[i-1] + primes[i] + 1;
			if (x > n) break;
			if (isPrime[x]) h.add(x);
		}
		
		out.println(h.size() >= k ? "YES" : "NO");
		
		out.flush();
	}
}
