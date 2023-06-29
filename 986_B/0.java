import java.io.*;
import java.util.*;

public class F {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;//in.nextInt();
        while(t-->0) { 
        	int n = in.nextInt();    
        	int a[] = in.readArray(n);
			int parity = 0;
			for(int i=0;i<n;i++){
				if(a[i]==-1) continue;
				parity ^= 1;
				int x = i;
				while(a[x]!=-1){
					int y = a[x];
					a[x] = -1;
					x = y-1;
				}
  	 		}
  	 		if(parity==1) out.println("Um_nik");
  	 		else out.println("Petr");
        }
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int j = random.nextInt(n), temp = a[j];
			a[j] = a[i]; a[i] = temp;
		}
		Arrays.sort(a); 	
	}
}
