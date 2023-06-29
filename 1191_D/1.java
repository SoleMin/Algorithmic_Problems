import java.io.*;
import java.util.*;

public class D {

	public static BufferedReader br;
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		readInput();
		out.close();
	}
	static int n;
	static long[] a;
	
	static void solve() {
		boolean firstwin = true;
		// Auto lose: Everything is zero, three or more of the same exist, two doubles, or the game is like two types of stones and it's not two piles.
		if (n == 1) firstwin = a[0]%2==1 ? true:false;
		else if (n == 2) {
			if (a[0] + a[1] == 0) firstwin = false;
			else if ((a[0]+a[1])%2 == 0) firstwin = true;
			else firstwin = false;
		}
		else {
			HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
			int numdub = 0;
			long dub = 0;
			for (long x: a) {
				if (!hm.containsKey(x)) hm.put(x, 0);
				hm.put(x, hm.get(x)+1);
				if (hm.get(x) == 3) firstwin = false; // Handles all zero fine
				if (hm.get(x) == 2) {
					numdub++;
					dub = x;
				}
			}
			if (numdub >= 2) firstwin = false;
			if (numdub == 1) {
				// If theres like 35788 we fail but treeset doesnt catch that.
				if (hm.containsKey(dub-1)) firstwin=false;
			}
		}
		if (!firstwin) out.println("cslnb");
		else if (n >= 2){
			// My intution is screaming they will attempt to make the longest increasing sequence starting with zero.
			// Whoever is the sucekr in this situation takes the L.
			//  If there is not this increasing sequence, that MUST necessarily trigger a weird condition. So, if we ever go negative, we know first loses.
			Arrays.sort(a);
			long extra = 0;
			for (int i = 0; i < n; i++) {
				long bias = a[i]-i;
				if (bias < 0) firstwin = false;
				extra += bias;
			}
			if (firstwin) {
				if (extra % 2 == 0) firstwin = false;
				else firstwin = true;
			}
			out.println(firstwin ? "sjfnb": "cslnb");
		}
		else out.println(firstwin ? "sjfnb": "cslnb");
	}
	
	public static void readInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// br = new BufferedReader(new FileReader("in.in"));
		n = Integer.parseInt(br.readLine());
		a= new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		solve();
	}
}
