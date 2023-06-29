import java.io.*;
import java.util.*;

public class ProblemaNoldbaha implements Runnable{
	public static void main(String[] args) throws IOException {
		new Thread(new ProblemaNoldbaha()).start();
	}
	
	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;
	
	public String nextToken() throws IOException{
		while (in == null || !in.hasMoreTokens()){
			in = new StringTokenizer(br.readLine());
		}
		
		return in.nextToken();
	}
	
	public int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	public double nextDouble() throws IOException{
		return Double.parseDouble(nextToken());
	}
	
	public void solve() throws IOException{
		int n = nextInt();
		int k = nextInt();
		
		int[] prime = new int[1000];
		
		int l = 0;
		
		for (int i = 2; i <= n; i++) {
			boolean f = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0){
					f = true;
					break;
				}
			}
			
			if (!f){
				prime[l] = i;
				l++;
			}
		}
		
		int count = 0;
		for (int i = 2; i < l; i++) {
			boolean f = false;
			for (int j = 0; j < l - 1; j++) {
				if (prime[j] + prime[j + 1] + 1 == prime[i]){
					f = true;
					break;
				}
			}
			
			if (f) count++;
		}
		
		if (count >= k){
			out.println("YES");
		}
		else{
			out.println("NO");
		}
	}
	
	public void run(){
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			
			solve();
			
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
