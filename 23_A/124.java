

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A23 implements Runnable {

	private void Solution() throws IOException {
		String s = in.readLine();
		int n = s.length(), ans = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = i; j < n; j ++) {
				for (int k = i+1; k <= n; k ++) {
					for (int g = k; g <= n; g ++) {
						if (s.substring(i,j).equals(s.substring(k,g))) {
							int l = s.substring(i,j).length();
							ans = Math.max(ans, l);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String args[]) {
		new A23().run();
	}
	
	BufferedReader in;
	StringTokenizer tokenizer;
	
	public void run() {
		try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            Solution();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}
	
	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(in.readLine());
		return tokenizer.nextToken();
	}
}
