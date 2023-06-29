// discussed with rainboy
import java.io.*;
import java.util.*;

public class CF911D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		boolean odd = false;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (aa[i] > aa[j])
					odd = !odd;
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int k = r - l + 1;
			if ((long) k * (k - 1) / 2 % 2 != 0)
				odd = !odd;
			pw.println(odd ? "odd" : "even");
		}
		pw.close();
	}
}
