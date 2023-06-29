import java.io.*;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import javax.print.attribute.HashAttributeSet;

public class CodeForces {

	public void solve() throws IOException {
		int n = nextInt();
		int arr[]=new int[1000];
		arr[0]=0;
		arr[1]=1;
		arr[2]=1;
		if(n==0){
			out.print("0 0 0");
		}
		else if(n==1){
			out.print("0 0 1");
		} else {
			int c=2;
			while(arr[c]!=n){
				c++;
				arr[c]=arr[c-1]+arr[c-2];
			}
			out.print(arr[c-2]+" "+arr[c-2]+" "+arr[c-3]);
		}
		
		
	}

	public static void main(String[] args) {
		new CodeForces().run();
	}
	
	

	int NOD(int a, int b) {
		while (a != 0 && b != 0) {
			if (a >= b)
				a = a % b;
			else
				b = b % a;
		}
		return a + b;
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter out;
	boolean isOuterFile = false;

	public void run() {
		try {
			if (isOuterFile) {
				reader = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
				out = new PrintWriter(System.out);
			} else {
				reader = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}

			tokenizer = null;	
			// long t=new Date().getTime();
			solve();
			// writer.println(t-new Date().getTime());
			reader.close();
			out.close();
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