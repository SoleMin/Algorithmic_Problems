import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main implements Runnable {	
	
	int n;
	double[] prob;
	double[][] a;
	
	void solve() throws IOException {
		n = nextInt();
		a = new double[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = nextDouble();
			}
		}
		prob = new double[1<<n];
		Arrays.fill(prob, 0.0);
		prob[(1<<n)-1] = 1.0;
		for (int i = (1<<n)-1; i > 1; --i) {
			int c = 0;
			for (int bit = 0; bit < n; ++bit) {
				if (((1<<bit) & i) > 0) {
					++c;
				}
			}
			double k = c * (c - 1) / 2.0;
			for (int f = 0; f < n; ++f) {
				if (((1<<f) & i) > 0) {
					for (int s = f+1; s < n; ++s) {
						if (((1<<s) & i) > 0) {
							prob[i^(1<<f)] += prob[i] * a[s][f] / k;
							prob[i^(1<<s)] += prob[i] * a[f][s] / k;
						}
					}
				}
			}
		}
		for (int i = 0; i < n; ++i) {
			writer.printf(Locale.US, "%.6f ", prob[1<<i]);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		 new Thread(null, new Runnable() {
            public void run() {
                new Main().run();
            }
	     }, 
	     "1", 
	     1 << 25).start();
	}
	
	@Override
	public void run() {
		try {
			boolean fromStandart = true;
			reader = new BufferedReader(fromStandart ? new InputStreamReader(System.in) : new FileReader(INFILE));
            writer = new PrintWriter(new BufferedWriter(fromStandart ? new OutputStreamWriter(System.out) : new FileWriter(OUTFILE)));
			tokenizer = null; 
			solve();
			writer.flush();
		} catch (Exception error) {
			error.printStackTrace();
			System.exit(1);
		}
	}
	
	static final String INFILE = "input.txt";
	static final String OUTFILE = "output.txt";
	
	BufferedReader reader;
	StringTokenizer tokenizer;
    PrintWriter writer;

	int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    String nextString() throws IOException {
    	return reader.readLine();
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    } 	

}
