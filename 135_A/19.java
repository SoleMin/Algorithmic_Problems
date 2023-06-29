import java.io.*;
import java.util.*;
import java.util.prefs.NodeChangeEvent;
import java.math.*;

public class Main implements Runnable {
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;
	private Random rnd;
	
	private void solve() throws IOException {
		int n = nextInt();
		
		int[] a = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			a[i] = nextInt();
			if(a[i] > a[max]) max = i;
		}
		
		int value = 1;
		
		if(a[max] == 1) value = 2;
		
		a[max] = value;
		
		Arrays.sort(a);
		
		for(int i = 0; i < n; i++) {
			out.print(a[i]);
			out.print(' ');
		}
	}
		
	public static void main(String[] args) {
		new Main().run();
	} 
	
	public void run() {
		try {
			try {
				in = new BufferedReader(new FileReader("INPUT.TXT"));
				out = new PrintWriter(new FileWriter("OUTPUT.TXT"));
			} catch(FileNotFoundException e) {
				in = new BufferedReader(new InputStreamReader((System.in)));
				out = new PrintWriter(System.out);
			}
			
			st = null;
			rnd = new Random();
			
			solve();
			
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	private String nextToken() throws IOException, NullPointerException {
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		
		return st.nextToken();
	}
	
	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

}