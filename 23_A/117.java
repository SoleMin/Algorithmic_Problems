import java.io.*;
import java.util.*;

public class A implements Runnable {

	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public static void main(String[] args) {
		new Thread(new A()).start();
	}

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void solve() throws IOException {
		String s = nextToken();
		int max = 0;
		for(int i = 0 ; i < s.length(); i++)
			for(int j = i+1 ; j < s.length(); j ++){
				String sub = s.substring(i, j);
				int kv = 0;
				for(int k = 0 ; k<= s.length() - sub.length(); k ++){
					boolean ok = true;
					for(int g = 0 ; g < sub.length(); g ++)
					if (sub.charAt(g) != s.charAt(g+k)){
						ok = false;
						break;
					}
					if (ok) kv ++;
				}
				if (kv > 1)
				max = Math.max(max, sub.length());
			}
				
		out.println(max);
	}

	public void run() {
		try {
				br = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
		
		//		br = new BufferedReader(new FileReader("input.txt"));
		//		out = new PrintWriter("output.txt");
		
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

}
