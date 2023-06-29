import java.io.*;
import java.util.*;

public class CF15A {
	static class House implements Comparable<House> {
		int x, a;
		House(int x, int a) {
			this.x = x;
			this.a = a;
		}
		@Override public int compareTo(House h) {
			return x - h.x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		House[] hh = new House[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			hh[i] = new House(x, a);
		}
		Arrays.sort(hh);
		int cnt = 2;
		for (int i = 1; i < n; i++) {
			int gap = (hh[i].x - hh[i - 1].x - t) * 2 - (hh[i].a + hh[i - 1].a);
			if (gap > 0)
				cnt += 2;
			else if (gap == 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
