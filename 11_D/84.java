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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main implements Runnable {	
	
	int n;
	long[][] f;
	boolean[][] e;
	
	int bit(int value) {
		return (1<<value);
	}
	
	void solve() throws IOException {
		n = nextInt();
		int m = nextInt();
		f = new long[1<<n][n];
		e = new boolean[n][n];
		for (int i = 0; i < (1<<n); ++i) {
			for (int j = 0; j < n; ++j) {
				f[i][j] = -1;
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				f[bit(i)|bit(j)][j] = 0;
				e[i][j] = false;
			}
		}
		for (int i = 0; i < m; ++i) {
			int u = nextInt()-1;
			int v = nextInt()-1;
			e[u][v] = true;
			e[v][u] = true;
			if (u < v) {
				f[bit(u)|bit(v)][v] = 1;
			}
			else {
				f[bit(v)|bit(u)][u] = 1;
			}
		}
		long answer = 0;
		for (int i = 1; i < (1<<n); ++i) {
			int start = 0;
			while (((1<<start)&i) == 0) {
				++start;
			}
			int s = bit(start);
			for (int nxt = start+1; nxt < n; ++nxt) {
				int b = bit(nxt);
				if ((b&i) > 0 && (b|s) != i) {
					if (e[start][nxt]) {
						answer += clc(i, nxt);
					}
				}
			}
		}
		writer.print(answer>>1);
	}
	
	long clc(int maska, int last) {
		if (f[maska][last] == -1) {
			int first = 0;
			while (((1<<first)&maska) == 0) {
				++first;
			}
			f[maska][last] = 0;
			for (int b = first+1; b < n; ++b) {
				if ((bit(b)&maska)>0) {
					if (e[b][last]) {
						f[maska][last] += clc(maska^bit(last), b);
					}
				}
			}		
		}
		return f[maska][last];
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
