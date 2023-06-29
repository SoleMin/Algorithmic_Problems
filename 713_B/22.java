import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		int left = 0, right = n;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0, x4 = 0, y4 = 0;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+1+" "+mid+" "+n);
			int ans = nextInt();
			if (ans==2)
				right = mid;
			else
				left = mid;
		}
		x4 = right;
		left = 0;
		right = n;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+1+" "+mid+" "+n);
			int ans = nextInt();
			if (ans >= 1)
				right = mid;
			else
				left = mid;
		}
		x2 = right;
		left = 1;
		right = n+1;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+mid+" "+1+" "+n+" "+n);
			int ans = nextInt();
			if (ans >= 1)
				left = mid;
			else
				right = mid;
		}
		x3 = left;
		left = 1;
		right = n+1;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+mid+" "+1+" "+n+" "+n);
			int ans = nextInt();
			if (ans >= 2)
				left = mid;
			else
				right = mid;
		}
		x1 = left;
		
		left = 0;
		right = n;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+1+" "+n+" "+mid);
			int ans = nextInt();
			if (ans>=2)
				right = mid;
			else
				left = mid;
		}
		y4 = right;
		left = 0;
		right = n;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+1+" "+n+" "+mid);
			int ans = nextInt();
			if (ans >= 1)
				right = mid;
			else
				left = mid;
		}
		y2 = right;
		left = 1;
		right = n+1;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+mid+" "+n+" "+n);
			int ans = nextInt();
			if (ans >= 1)
				left = mid;
			else
				right = mid;
		}
		y3 = left;
		left = 1;
		right = n+1;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			System.out.println("? "+1+" "+mid+" "+n+" "+n);
			int ans = nextInt();
			if (ans >= 2)
				left = mid;
			else
				right = mid;
		}
		y1 = left;
		if (y3 <= y2 && x3 <= x2) {
			System.out.println("! "+x3+" "+y3+" "+x2+" "+y2+" "+x1+" "+y1+" "+x4+" "+y4);
			return;
		}

		System.out.println("? "+x1+" "+y1+" "+x2+" "+y2);
		int ans1 = nextInt();
		System.out.println("? "+x3+" "+y3+" "+x4+" "+y4);
		int ans2 = nextInt();
		if (ans1==1 && ans2==1) {
			System.out.println("! "+x1+" "+y1+" "+x2+" "+y2+" "+x3+" "+y3+" "+x4+" "+y4);
			return;
		}
		
		System.out.println("? "+x1+" "+y3+" "+x2+" "+y4);
		ans1 = nextInt();
		System.out.println("? "+x3+" "+y1+" "+x4+" "+y2);
		ans2 = nextInt();
		if (ans1==1 && ans2==1) {
			System.out.println("! "+x1+" "+y3+" "+x2+" "+y4+" "+x3+" "+y1+" "+x4+" "+y2);
			return;
		}
		
		System.out.println("? "+x1+" "+y1+" "+x4+" "+y2);
		ans1 = nextInt();
		System.out.println("? "+x3+" "+y3+" "+x2+" "+y4);
		ans2 = nextInt();
		if (ans1==1 && ans2==1) {
			System.out.println("! "+x1+" "+y1+" "+x4+" "+y2+" "+x3+" "+y3+" "+x2+" "+y4);
			return;
		}
		
		System.out.println("? "+x1+" "+y3+" "+x2+" "+y2);
		ans1 = nextInt();
		System.out.println("? "+x3+" "+y1+" "+x4+" "+y4);
		ans2 = nextInt();
		if (ans1==1 && ans2==1) {
			System.out.println("! "+x1+" "+y3+" "+x2+" "+y2+" "+x3+" "+y1+" "+x4+" "+y4);
			return;
		}
		
		
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}