import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
	
	private static StringTokenizer tokenizer;
    private static BufferedReader bf;
    private static PrintWriter out;
    
	private static int nextInt() throws IOException {
    	return Integer.parseInt(nextToken());
    }
    
    @SuppressWarnings("unused")
	private static long nextLong() throws IOException {
    	return Long.parseLong(nextToken());
    }
    
    private static String nextToken() throws IOException {
    	while(tokenizer == null || !tokenizer.hasMoreTokens()) {
    		tokenizer = new StringTokenizer(bf.readLine());
    	}
    	return tokenizer.nextToken();
    }
    
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
    	tokenizer = null;
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	int n = nextInt();
    	if(n >= 0) out.println(n);
    	else {
    		n = -n;
    		int a = n % 10; int m = n/10;
    		int b = m % 10;
    		if(a >= b) {
    			if(m == 0) out.println(0);
    			else out.println(-m);
    		}
    		else {
    			m = (m-b)+a;
    			if(m == 0) out.println(0);
    			else out.println(-m);
    		}
    	}
    	out.close();
	}

}
