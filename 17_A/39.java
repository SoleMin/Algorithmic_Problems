import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.*;

public class Main implements Runnable {
	BufferedReader in;  
	StringTokenizer st = new StringTokenizer("");
	
	public static void main(String [] args) throws Exception {
		new Thread(new Main()).start();
	}

	 void printExit(String s) {
		System.out.println(s);
		System.exit(0);
	}

	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			int n = nextInt();
			int k = nextInt();
			int max = 5000;
			ArrayList <Integer> primes = new ArrayList <Integer> ();
			boolean [] p = new boolean [max];
			Arrays.fill(p, true);
			for (int i = 2; i < max; i++) {
				if (p[i]) {
					primes.add(i);
					for (int j = i * i; j < max; j += i)
						p[j] = false;
				}		
				
			}

			HashSet <Integer> good = new HashSet <Integer> ();
			for (int i = 0; i < primes.size() - 1; i++) {
				good.add(primes.get(i) + primes.get(i + 1) + 1);
			}

			int have = 0, pos = 0;
			while (true) {
				int i = primes.get(pos);     
				if (i > n) break;
				if (good.contains(i)) have++;
				pos++;
			}
			System.out.println(have >= k ? "YES" : "NO");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	 boolean seekForToken() {
 		try {
			while (!st.hasMoreTokens()) {
				String s = in.readLine();
				if (s == null) {
				 	return false;
				}
			 	st = new StringTokenizer(s);
			}
			return true;
		}
		catch (IOException e) {
		 	e.printStackTrace();
		 	return false;
		}
 	}

 	 int nextInt() {
		return Integer.parseInt(nextToken());
 	}

 	 long nextLong() {
		return Long.parseLong(nextToken());
 	}

 	 double nextDouble() {
		return Double.parseDouble(nextToken());
 	}

 	 BigInteger nextBigInteger() {
 	 	return new BigInteger(nextToken());
 	}

 	 String nextToken() {
 	 	seekForToken();
 	 	return st.nextToken();
 	}

}
