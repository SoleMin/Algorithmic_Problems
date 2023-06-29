import java.util.*;
import java.io.*;

public class Template {
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(rd.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		long s = n - m;
		s = Math.min(s, m / (k - 1));
		s = Math.min(s, n / k);
		long score = 0;
		score = (s * (k - 1))%P;
		long n1 = n - k * s, m1 = m - (k - 1) * s;
		sc = 0;
	//	rec(n, m);
	//	System.out.println(sc);
		if (m1 == n1) {
			score = (score + full(m1)) % P;
			System.out.println(score);
			return;
		}
			score = (score + m1) % P;
			System.out.println(score);
	}

	static long full(long N) {
		long x = N / k, r = N - x * k;
		long powTwo = powMod(2, x + 1) - 2 + 2*P;
		powTwo %= P;
		powTwo = (powTwo * k) % P;
		powTwo = (powTwo + r) % P;
		return powTwo;
	}
	
	static long sc = 0;
	
	static void rec(long N, long M){
		if(N==M){ sc = (sc + full(N))%P; return; }
		if(N>=k && M>=k-1){
			sc = (sc + (k-1))%P;
			rec(N-k, M-(k-1));
			return;
		}
		sc = (sc + M)%P;
	}

	static long powMod(long a, long p) {
		if (p == 0)
			return 1L;
		long h = powMod(a, (p >> 1));
		h = (h * h) % P;
		return p % 2 == 0 ? h : (a * h) % P;
	}

	static long n, m, k;

	static long P = 1000000009;

	static StringTokenizer st;
	static BufferedReader rd = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter pw = new PrintWriter(System.out);

}
