import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = null;
		writer = new PrintWriter(System.out);
		solve();
		reader.close();
		writer.close();
	}

	private static void solve() throws IOException {
		int n = nextInt();
		int[] mas = new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			mas[i]=nextInt();
			sum+=mas[i];
		}
		Arrays.sort(mas);
		int cs=0;
		int res=0;
		for(int i=n-1;i>=0;i--)
		{
			cs+=mas[i];
			sum-=mas[i];
			res++;
			if(cs>sum)
				break;
		}
		writer.println(res);		
	}
}