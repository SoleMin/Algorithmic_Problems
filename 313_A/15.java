import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class TaskA implements Runnable {
	
	@Override
	public void run() {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.readInt();
		if (n > 0) {
			out.println(n);
		}
		else {
			int nn = -n;
			int x = nn/10;
			int lastDigit = nn%10;
			int y = 10*(x/10) + lastDigit;
			x = -x;
			y = -y;
			out.println(x > y ? x : y);
		}
		out.flush();
	}

	public static void main(String[] args) {
		new TaskA().run();
	}
	
	private class InputReader {
		
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	    
	    public int readInt() {
	    	return Integer.parseInt(next());
	    }
	    
	}

}
