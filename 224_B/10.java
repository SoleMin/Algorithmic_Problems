import java.util.*;
import java.io.*;
public class B {
	public void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = nextInt();
		}
		int[] num = new int[n];
		Set<Integer> set = new HashSet<Integer>();
		int s = -1;
		int l = -1;
		for(int i = 0; i < n; i++){
			set.add(a[i]);
			num[i] = set.size();
			if( num[i] == k ){
				l = i+1;
				set = new HashSet<Integer>();
				for(int j = i; j >= 0; j--){
					set.add(a[j]);
					if( set.size() == k ){
						s = j+1;
						break;
					}
				}
				break;
			}
		}
		writer.println(s + " " + l);
 	}

	public static void main(String[] args) throws IOException {
		new B().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() throws IOException {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}
