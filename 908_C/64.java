import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class C {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		double r = in.nextInt();
		double x[] = new double[n];
		for(int i = 0; i < n; i++)
			x[i] = in.nextDouble();
		
		double y[] = new double[n];
		y[0] = r;
		
		for(int i = 1; i < n; i++){
			double miny = r;
			for(int j = 0; j < i; j++){
				double dx = Math.abs(x[i]-x[j]);
				if(dx > r*2) continue;
				double yy = Math.sqrt(4*r*r-dx*dx);
				miny = Math.max(miny, yy+y[j]);
			}
			y[i] = miny;
		}
		for(int i = 0; i < n; i++){
			System.out.print(y[i]+" ");
		}
		

	}

	
	
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String s) {
			try{
				br = new BufferedReader(new FileReader(s));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public FastScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken()	{
			while(st == null ||!st.hasMoreElements()){
				try {
				st = new StringTokenizer(br.readLine());}
				catch(IOException e) {
					e.printStackTrace();
				}			
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(nextToken());
		}
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
		String next() {
			return nextToken();
		}
		
	}
}
