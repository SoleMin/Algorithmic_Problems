import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static class Task {
		
		int NN = 500005;
		int MOD = 1000000007;
		int INF = 2000000000;
		long INFINITY = 2000000000000000000L;
		
		public void solve(InputReader in, PrintWriter out) {
			int t = in.nextInt();
			while(t-->0) {
				long n = in.nextLong();
				long k = in.nextLong();
				if(n < 32 && k > ((1L<<(2L*n))-1L)/3L) {
					out.println("NO");continue;
				}
				if(n == 2 && k == 3) {
					out.println("NO");continue;
				}
				if(n >= 32) {
					out.println("YES "+ (n-1));continue;
				}
				boolean done = false;
				for(long i=1;i<=n;++i) {
					if(k < (1L<<(i+2L))-i-3L) {
						done = true;
						out.println("YES " + (n - i));break;
					}
				}
				if(!done) {
					out.println("YES 0");
				}
			}
		}
		
	}
	
	static void prepareIO(boolean isFileIO) {
		//long t1 = System.currentTimeMillis();
		Task solver = new Task();
		// Standard IO
		if(!isFileIO) { 
			InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        solver.solve(in, out);
	        //out.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        out.close();
		}
        // File IO
		else {
			String IPfilePath = System.getProperty("user.home") + "/Downloads/ip.in";
	        String OPfilePath = System.getProperty("user.home") + "/Downloads/op.out";
	        InputReader fin = new InputReader(IPfilePath);
	        PrintWriter fout = null;
	        try {
				fout = new PrintWriter(new File(OPfilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        solver.solve(fin, fout);
	        //fout.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        fout.close();
		}
	}
	
	public static void main(String[] args) {
        prepareIO(false);
	}
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        
        public InputReader(String filePath) {
        	File file = new File(filePath);
            try {
				reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            tokenizer = null;
        }
        
        public String nextLine() {
        	String str = "";
        	try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return str;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        
    }

}