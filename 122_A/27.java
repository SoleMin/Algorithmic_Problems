

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A implements Runnable {

	private void Solution() throws IOException {
		int n = nextInt();
		if (n % 7 == 0 || n % 4 == 0 || n % 47 == 0 || n % 74 == 0 || n % 747 == 0 || n % 474 == 0 || n % 777 == 0 || n % 444 == 0 || n % 774 == 0 || n % 447 == 0 || n % 744 == 0 || n % 477 == 0)
			System.out.println("YES"); else 
				System.out.println("NO");
	}
	
	public static void main(String args[]) {
		new A().run();
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
