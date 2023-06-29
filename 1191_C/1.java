import java.io.*;
import java.util.*;

public class C {

	public static BufferedReader br;
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		readInput();
		
		int ops = 0;
		long curheight = k;
		int pt = 0;
		while (pt < m) {
			//System.out.println(curheight);
			long bias = 0;
			while (pt < m && s[pt]<= curheight) {
				pt++;
				bias++;
			}
			if (bias == 0) {
				// Skip to next thing that we dont end up losing pt.
				//curheight + k*x <= s[pt]
				// (s[pt]-curheight)/k;
				long toadd = (s[pt]-curheight+k-1)/k*k;
				if (toadd == 0) break;
				curheight += toadd;
			}
			else{
				curheight += bias;
				ops++;
			}
			
		}
		out.println(ops);
		out.close();
	}
	static int m;
	static long n, k;
	static long[] s;
	public static void readInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// br = new BufferedReader(new FileReader("in.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n  = Long.parseLong(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		s = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ;i  <m; i++)s[i] = Long.parseLong(st.nextToken());
	}
}
