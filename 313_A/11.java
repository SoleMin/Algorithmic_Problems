import java.io.*;

public class Main {
	
	StreamTokenizer in;
	int n, k;
	
	public void run() {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		read();
		print(solve());
	}
	
	void read() {
		n = nextInt();
//		k = nextInt();
	}
	
	int solve() {
		int result = n;
		if (result < 0) {
			int res1 = n / 10;
			int mod = n % 10;
			
			int res2 = res1 / 10 * 10 + mod;
			if (res1 > res2)
				result = res1;
			else
				result = res2;
		}
		
		return result;
	}
	
	void print(int result) {
		System.out.println(result);
	}
	
	
	public static void main(String[] Args) {
			new Main().run();
	}
	
	public int nextInt() {
		try {
			in.nextToken();
		}
		catch (Exception e) {}
		return (int)in.nval;
	}
	
	public String nextString() {
		try {
			in.nextToken();
		}
		catch (Exception e) {}
		return in.sval;
	}
}