import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemA {
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String[] data = s.readLine().split(" ");
		int n = Integer.valueOf(data[0]);
		int k = Integer.valueOf(data[1]);
		
		
		long[] a = new long[n];
		String[] ai = s.readLine().split(" ");
		for (int i = 0 ; i < n ; i++) {
			a[i] = Integer.valueOf(ai[i]);
		}
		for (int i = 0 ; i < n ; i++) {
			int tm = (int)(Math.random() * n);
			long tmp = a[tm];
			a[tm] = a[i];
			a[i] = tmp;
		}
		Arrays.sort(a);

		Set<Long> invalid = new HashSet<Long>();
		int cnt = 0;
		for (int i = 0 ; i < n ; i++) {
			if (!invalid.contains(a[i])) {
				cnt++;
				invalid.add(a[i] * k);
			}
		}
		out.println(cnt);
		out.flush();
	}


	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}