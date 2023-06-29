// package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class F {

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), d = sc.nextInt();
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < a.length; i++) {
			int tmp = a[i] - d;
			if(i == 0 || tmp > a[i-1] && tmp - a[i-1] >= d)
				set.add(tmp);
			tmp = a[i] + d;
			if(i == n-1 || tmp < a[i+1] && a[i+1] - tmp >= d)
				set.add(tmp);
 		}
		out.println(set.size());
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader)
		{
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public boolean ready() throws IOException
		{
			return br.ready();
		}
	}
}