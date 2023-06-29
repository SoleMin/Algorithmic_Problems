import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class A {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
	public void solve() throws IOException {				
		long A = nextLong();
		long B = nextLong();		
		long ans = 0;
		while(A > 0){
			if(A >= B){
				ans += A/B;
				A %= B;
				if(A == 0) break;
			}
			else{
				long tmp = A; A = B; B = tmp;
			}			
		}		
		out.println(ans);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new A().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
