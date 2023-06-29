import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class Main {
 
	private BufferedReader input;
	private PrintWriter output;
	private StringTokenizer stoken;
 
	String fin = "input";
	String fout = "output";
 
 
	private void solve() {

		long a = nextInt();
		
		long res = (a / 2) * 3;

		output.print(res);
		
	}
 
 
 
	Main() throws IOException {
		//input = new BufferedReader(new FileReader(fin + ".txt"));
		//output = new PrintWriter(new FileWriter(fout + ".txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		output = new PrintWriter(System.out);
 
 
		solve();
 
		input.close();
		output.flush();
		output.close();
	}
 
 
	int nextInt() {
		return Integer.parseInt(nextToken());
	}
 
	long nextLong() {
		return Long.parseLong(nextToken());
	}
 
	double nextFloat() {
		return Float.parseFloat(nextToken());
	}
 
	double nextDouble() {
		return Double.parseDouble(nextToken());
	}
 
	String nextToken() {
		while ((stoken == null) || (!stoken.hasMoreTokens())) {
			try {
				String line = input.readLine();
				stoken = new StringTokenizer(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stoken.nextToken();
	}
 
 
 
	public static void main(String[] args) throws IOException {
		new Main();
	}
 
}


class Tarif {
	public int abPlata;
	public int tMin;
	public int price;
	public long res;
}