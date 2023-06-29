import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeForces {

	public void solve() throws IOException {
		int n=nextInt();
		int t=nextInt();
		double larr[]=new double [n];
		double rarr[]=new double [n];		
		for(int i=0;i<n;i++){
			double x=nextDouble();
			double r=nextDouble();
			larr[i]=x-r/2;
			rarr[i]=x+r/2;
		}
		Arrays.sort(larr);
		Arrays.sort(rarr);
		
		int counter=2;
		for(int i=1;i<n;i++){
			if(larr[i]-rarr[i-1]>t){
				counter+=2;
			} else if(larr[i]-rarr[i-1]==t){
				counter++;
			}
		}
		
		writer.print(counter);
	}

	public static void main(String[] args) {
		new CodeForces().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			//reader = new BufferedReader(new FileReader("input.txt"));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			//writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			// long t=new Date().getTime();
			solve();
			// writer.println(t-new Date().getTime());
			reader.close();
			writer.close();
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