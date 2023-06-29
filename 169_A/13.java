import java.io.*;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws Exception {
		
		int n = nextInt();
		int a = nextInt();
		int b = nextInt();
		int[] tasks = new int[n];
		for(int i = 0; i < n; i++){
			tasks[i] = nextInt();
		}
		Arrays.sort(tasks);
		exit(tasks[b] - tasks[b-1]);
		
	}
	
	private static PrintWriter out;
	private static BufferedReader inB;
	private static boolean FILE = false; 
	
	static {
		try {
			out = new PrintWriter(FILE ? (new FileOutputStream("output.txt")) : System.out);
			inB = new BufferedReader(new InputStreamReader(FILE ? new FileInputStream("input.txt") : System.in));
		} catch(Exception e) {e.printStackTrace();}
	}
	
	private static StreamTokenizer in = new StreamTokenizer(inB);
	
	private static void exit(Object o) throws Exception {
		out.println(o);
		out.flush();
		System.exit(0);
	}
	private static void println(Object o) throws Exception{
		out.println(o);
		out.flush();
	}
	private static void print(Object o) throws Exception{
		out.print(o);
		out.flush();
	}
	private static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}  
	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;        
	}
} 